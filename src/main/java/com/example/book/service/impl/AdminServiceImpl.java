package com.example.book.service.impl;

import com.example.book.dao.AdminDao;
import com.example.book.dao.impl.AdminDaoImpl;
import com.example.book.domain.Admin;
import com.example.book.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {
        return dao.findByUsernameAndPassword(username, password);
    }
}
