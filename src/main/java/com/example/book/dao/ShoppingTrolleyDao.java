package com.example.book.dao;

import com.example.book.domain.ShoppingTrolley;

import java.util.List;

public interface ShoppingTrolleyDao {
    void add(ShoppingTrolley cart);

    // 根据 uid 和 bid 查询记录
    ShoppingTrolley findByUidAndBid(int uid, int bid);

    // 根据 sid 将数量加一
    void plusOneBySid(int sid);

    // 根据 uid 查询所有的记录
    List<ShoppingTrolley> findByUid(int uid);

    // 根据 sid 删除记录
    void removeBySid(int sid);

    void removeByUid(int uid);
}
