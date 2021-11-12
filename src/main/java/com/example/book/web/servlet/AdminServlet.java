package com.example.book.web.servlet;

import com.example.book.domain.Admin;
import com.example.book.domain.ResultInfo;
import com.example.book.service.AdminService;
import com.example.book.service.impl.AdminServiceImpl;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
    private AdminService service = new AdminServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = service.login(username, password);

        ResultInfo info = new ResultInfo();
        if (admin == null) {
            // 用户名或密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        } else {
            // 登陆成功，将 admin 存储到 session 中
            info.setFlag(true);
            request.getSession().setAttribute("admin", admin);
        }
        writeValue(info, response);
    }
}
