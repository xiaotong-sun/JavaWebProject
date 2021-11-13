package com.example.book.web.servlet;

import com.example.book.domain.ResultInfo;
import com.example.book.domain.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;

import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();

    /*
    登陆方法
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("verificationCode");

        HttpSession session = request.getSession();
        String codeServer = (String) session.getAttribute("VERIFICATION_CODE_SERVER");

        ResultInfo info = new ResultInfo();

        // 判断验证码是否正确
        if (codeServer.equalsIgnoreCase(code)) {
            // 验证码正确，判断登陆是否成功
            User user = service.login(username, password);
            if (user != null) {
                // 登陆成功
                info.setFlag(true);
                info.setData(user);
                request.getSession().setAttribute("user", user);
            } else {
                // 登陆失败
                info.setFlag(false);
                info.setErrorMsg("用户名或密码错误");
            }
        } else {
            // 验证码错误
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        }

        writeValue(info, response);
    }


    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();

        // 封装数据
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 进行注册
        boolean flag = service.register(user);

        ResultInfo info = new ResultInfo();
        if (flag) {
            // 注册成功
            info.setFlag(true);
        } else {
            // 注册失败
            info.setFlag(false);
            info.setErrorMsg("用户名重复！");
        }

        writeValue(info, response);
        printObj("----user/register", user);
    }

    // 查询用户是否登陆
    public void findLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultInfo info = new ResultInfo();
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            info.setFlag(true);
            info.setData(user);
        } else {
            info.setFlag(false);
        }
        writeValue(info, response);
        printObj("----user/findLogin", info);
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/HomePage.html");
    }
}
