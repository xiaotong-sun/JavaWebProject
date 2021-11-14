package com.example.book.dao.impl;

import com.example.book.dao.PurchaseDao;
import com.example.book.domain.Purchase;
import com.example.book.domain.ShoppingTrolley;
import com.example.book.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PurchaseDaoImpl implements PurchaseDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void add(ShoppingTrolley shop) {
        String sql = "insert into purchase(uid, bid, time, number, price,title) VALUES (?,?,?,?,?,?)";
        template.update(sql,
                shop.getUid(),
                shop.getBid(),
                format.format(new Date()),
                shop.getNumber(),
                shop.getPrice(),
                shop.getTitle());
    }

    @Override
    public List<Purchase> findByUid(int uid) {
        String sql = "select * from purchase where uid = ?";
        return template.query(sql, new BeanPropertyRowMapper<>(Purchase.class), uid);
    }
}
