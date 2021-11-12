package com.example.book.service.impl;

import com.example.book.dao.BookDao;
import com.example.book.dao.impl.BookDaoImpl;
import com.example.book.domain.Book;
import com.example.book.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();

    @Override
    public List<Book> findAll() {
        return dao.findAll();
    }
}
