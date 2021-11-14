package com.example.book.dao;

import com.example.book.domain.Purchase;
import com.example.book.domain.ShoppingTrolley;

import java.util.List;

public interface PurchaseDao {
    // 添加一条购买记录
    void add(ShoppingTrolley shop);

    List<Purchase> findByUid(int uid);
}
