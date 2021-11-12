package com.example.book.web.servlet;

import com.example.book.domain.ResultInfo;
import com.example.book.domain.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();

        // 封装数据
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Servlet: " + user);

        // 进行注册
        boolean flag = service.regist(user);

        ResultInfo info = new ResultInfo();
        if (flag) {
            // 注册成功
            info.setFlag(true);
//            info.setData(user);
        } else {
            // 注册失败
            info.setFlag(false);
            info.setErrorMsg("用户名重复！");
        }
        writeValue(info, response);
    }

    public void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");

        boolean flag = service.active(code);
        if (flag) {
            // 激活成功
            response.sendRedirect(request.getContextPath() + "/HomePage.html");
        }else {
            // 激活失败
            response.sendRedirect(request.getContextPath() + "/regist_error.html");
        }

    }
}
