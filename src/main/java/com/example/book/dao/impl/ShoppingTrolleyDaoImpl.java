package com.example.book.dao.impl;

import com.example.book.dao.ShoppingTrolleyDao;
import com.example.book.domain.ShoppingTrolley;
import com.example.book.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class ShoppingTrolleyDaoImpl implements ShoppingTrolleyDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private RowMapper<ShoppingTrolley> rowMapper = new BeanPropertyRowMapper<>(ShoppingTrolley.class);

    @Override
    public void add(ShoppingTrolley cart) {
        String sql = "insert into shopping_trolley(uid,bid,number,price,title) values(?,?,?,?,?)";
        template.update(sql, cart.getUid(), cart.getBid(), 1, cart.getPrice(), cart.getTitle());
    }

    @Override
    public ShoppingTrolley findByUidAndBid(int uid, int bid) {
        String sql = "select * from shopping_trolley where uid = ? and bid = ?";

        try {
            return template.queryForObject(sql, rowMapper, uid, bid);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public void plusOneBySid(int sid) {
        String sql = "update shopping_trolley set number = number + 1, price = price+ price where sid = ?";
        template.update(sql, sid);
    }

    @Override
    public List<ShoppingTrolley> findByUid(int uid) {
        String sql = "select * from shopping_trolley where uid = ?";
        return template.query(sql, rowMapper, uid);
    }

    @Override
    public void removeBySid(int sid) {
        String sql = "delete from shopping_trolley where sid = ?";
        template.update(sql, sid);
    }

    @Override
    public void removeByUid(int uid) {
        String sql = "delete from shopping_trolley where uid = ?";
        template.update(sql, uid);
    }
}
