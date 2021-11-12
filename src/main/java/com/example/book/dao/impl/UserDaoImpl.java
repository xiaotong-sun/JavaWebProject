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

    @Override
    public User findByUsername(String username) {
        String sql = "select * from user where username = ?";

        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user(username, password, email, nickname,code) values (?,?,?,?,?)";

        template.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getNickname(),
                user.getCode());
    }

    @Override
    public void active(String code) {
        String sql = "update user set state = ? where code = ?";

        template.update(sql, "Y", code);
    }

    @Override
    public User findByCode(String code) {
        String sql = "select * from user where code = ?";

        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
        } catch (Exception e) {
            return null;
        }
    }
}
