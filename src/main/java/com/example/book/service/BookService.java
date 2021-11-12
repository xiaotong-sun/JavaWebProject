package com.example.book.service;

import com.example.book.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
