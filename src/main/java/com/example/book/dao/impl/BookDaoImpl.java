package com.example.book.dao.impl;

import com.example.book.dao.BookDao;
import com.example.book.domain.Book;
import com.example.book.domain.BookNumber;
import com.example.book.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.security.SecureRandom;
import java.util.List;
import java.util.Objects;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);

    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        return template.query(sql, rowMapper);
    }

    @Override
    public List<Book> findByTitle(String title) {
        String sql = "select * from book where title like ?";
        return template.query(sql, rowMapper, "%" + title + "%");
    }

    @Override
    public Book findByBid(int bid) {
        String sql = "select * from book where bid = ?";
        try {
            return template.queryForObject(sql, rowMapper, bid);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int findMaxBid() {
        String sql = "select max(bid) as 'maxBid' from book";
        return Objects.requireNonNull(template.queryForObject(sql, new BeanPropertyRowMapper<>(BookNumber.class))).getMaxBid();
    }
}
