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
            dao.add(user);
            return true;
        }
    }
}
