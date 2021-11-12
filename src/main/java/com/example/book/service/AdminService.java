package com.example.book.service;

import com.example.book.domain.Admin;

public interface AdminService {
    // 管理员登陆
    Admin login(String username, String password);
}
