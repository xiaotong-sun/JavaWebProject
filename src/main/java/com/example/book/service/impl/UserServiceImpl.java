package com.example.book.service.impl;

import com.example.book.dao.UserDao;
import com.example.book.dao.impl.UserDaoImpl;
import com.example.book.domain.User;
import com.example.book.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return dao.findByUsernameAndPassword(username, password);
    }
}
