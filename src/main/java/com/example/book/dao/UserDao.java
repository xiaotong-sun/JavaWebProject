package com.example.book.dao;

import com.example.book.domain.User;

public interface UserDao {
    // 通过用户名和密码查询用户
    User findByUsernameAndPassword(String username, String password);
}
