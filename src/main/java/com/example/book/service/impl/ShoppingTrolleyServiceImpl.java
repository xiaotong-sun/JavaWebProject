package com.example.book.service.impl;

import com.example.book.dao.BookDao;
import com.example.book.dao.ShoppingTrolleyDao;
import com.example.book.dao.impl.BookDaoImpl;
import com.example.book.dao.impl.ShoppingTrolleyDaoImpl;
import com.example.book.domain.ShoppingTrolley;
import com.example.book.service.BookService;
import com.example.book.service.ShoppingTrolleyService;

import java.util.List;

public class ShoppingTrolleyServiceImpl implements ShoppingTrolleyService {
    private ShoppingTrolleyDao dao = new ShoppingTrolleyDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void add(ShoppingTrolley cart) {
        ShoppingTrolley shopping = dao.findByUidAndBid(cart.getUid(), cart.getBid());

        if (shopping == null) {
            // 这是一条新的记录，从 book 中查询书名
            cart.setTitle(bookDao.findByBid(cart.getBid()).getTitle());
            dao.add(cart);
        } else {
            // 这条记录已经存在，则加一即可
            dao.plusOneBySid(shopping.getSid());
        }
    }

    @Override
    public List<ShoppingTrolley> findByUid(String uid) {
        return dao.findByUid(Integer.parseInt(uid));
    }

    @Override
    public void remove(String sid) {
        dao.removeBySid(Integer.parseInt(sid));
    }
}
