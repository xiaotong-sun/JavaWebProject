package com.example.book.service.impl;

import com.example.book.dao.BookDao;
import com.example.book.dao.impl.BookDaoImpl;
import com.example.book.domain.Book;
import com.example.book.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();

    @Override
    public List<Book> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Book> findRangeByBid(String _bid) {
        int maxBid = dao.findMaxBid();
        int bid = Integer.parseInt(_bid);

        List<Book> list = new ArrayList<>();
        int endBid = Math.min(bid + 4, maxBid);
        for (int i = bid; i <= endBid; i++) {
            list.add(dao.findByBid(i));
        }

        return list;
    }

    @Override
    public void add(Book book) {

    }
}
