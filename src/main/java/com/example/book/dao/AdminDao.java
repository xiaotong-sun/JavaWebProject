package com.example.book.dao;

import com.example.book.domain.Admin;

public interface AdminDao {
    // 通过用户名和密码查询
    Admin findByUsernameAndPassword(String username, String password);
}
