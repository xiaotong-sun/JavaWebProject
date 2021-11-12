package com.example.book.service;

import com.example.book.domain.User;

public interface UserService {
    User login(String username, String password);
}
