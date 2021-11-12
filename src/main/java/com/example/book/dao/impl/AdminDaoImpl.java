package com.example.book.dao.impl;

import com.example.book.dao.AdminDao;
import com.example.book.domain.Admin;
import com.example.book.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Admin findByUsernameAndPassword(String username, String password) {
        String sql = "select * from admin where username = ? and password = ?";
        try {
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(Admin.class),username,password);
        }catch (Exception e){
            return null;
        }
    }
}
