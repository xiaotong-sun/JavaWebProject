package com.example.book.dao;

import com.example.book.domain.Book;

import java.util.List;

public interface BookDao {
    // 查询所有的书籍
    List<Book> findAll();

    // 通过书名模糊查询
    List<Book> findByTitle(String title);

    // 通过 bid 查询书籍
    Book findByBid(int bid);
}
