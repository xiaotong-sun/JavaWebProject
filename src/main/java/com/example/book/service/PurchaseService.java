package com.example.book.service;

import com.example.book.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    // 一键购买
    void buyAll(String uid);

    // 通过 uid 查询购买记录
    List<Purchase> findAll(String uid);
}
