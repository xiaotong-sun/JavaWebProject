package com.example.book.service;

import com.example.book.domain.Book;

import java.util.List;

public interface BookService {
    // 查询所有书
    List<Book> findAll();

    // 根据 bid 查询 5 本书
    List<Book> findRangeByBid(String bid);

    void add(Book book);
}
