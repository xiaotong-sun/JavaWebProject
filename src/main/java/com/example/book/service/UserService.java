package com.example.book.service;

import com.example.book.domain.User;

public interface UserService {


    // 根据用户名和密码登陆
    User login(String username, String password);

    // 注册一个用户
    boolean register(User user);

    boolean checkPassword(String uid, String oldPassword);

    void updatePasswordByUid(String uid, String newPassword);
}
