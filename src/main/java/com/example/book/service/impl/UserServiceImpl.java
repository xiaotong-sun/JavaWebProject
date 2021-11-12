package com.example.book.service.impl;

import com.example.book.dao.UserDao;
import com.example.book.dao.impl.UserDaoImpl;
import com.example.book.domain.User;
import com.example.book.service.UserService;

import com.example.book.utils.MailUtils;
import com.example.book.utils.UUIDUtil;


public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return dao.findByUsernameAndPassword(username, password);
    }

    @Override
    public boolean register(User user) {
        if (dao.findByUsername(user.getUsername()) != null) {
            // 如果用户名存在
            return false;
        } else {
            // 用户名不存在，可以注册
            user.setCode(UUIDUtil.getUUID());
            System.out.println("Service: " + user);

            dao.add(user);

            String text = "<a href='http://localhost:8080/book/user/active?code=" + user.getCode() + "'>点击激活账号</a>";
            MailUtils.sendMail(user.getEmail(), text, "激活邮件");
            return true;
        }
    }

    @Override
    public boolean active(String code) {
        if (dao.findByCode(code) == null) {
            return false;
        } else {
            dao.active(code);
            return true;
        }
    }

}
