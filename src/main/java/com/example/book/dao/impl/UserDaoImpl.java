package com.example.book.dao.impl;

import com.example.book.dao.UserDao;
import com.example.book.domain.User;
import com.example.book.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";

        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (Exception e) {
            return null;
        }
    }
}
