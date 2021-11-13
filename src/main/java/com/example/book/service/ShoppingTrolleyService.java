package com.example.book.service;

import com.example.book.domain.ShoppingTrolley;

import java.util.List;

public interface ShoppingTrolleyService {

    // 添加一条购物车记录
    void add(ShoppingTrolley cart);

    // 根据 uid 查询购物车记录
    List<ShoppingTrolley> findByUid(String uid);

    void remove(String sid);
}
