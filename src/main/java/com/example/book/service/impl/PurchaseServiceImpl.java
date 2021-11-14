package com.example.book.service.impl;

import com.example.book.dao.PurchaseDao;
import com.example.book.dao.ShoppingTrolleyDao;
import com.example.book.dao.impl.PurchaseDaoImpl;
import com.example.book.dao.impl.ShoppingTrolleyDaoImpl;
import com.example.book.domain.Purchase;
import com.example.book.domain.ShoppingTrolley;
import com.example.book.service.PurchaseService;

import java.util.List;

public class PurchaseServiceImpl implements PurchaseService {
    PurchaseDao purchaseDao = new PurchaseDaoImpl();
    ShoppingTrolleyDao cartDao = new ShoppingTrolleyDaoImpl();

    @Override
    public void buyAll(String _uid) {
        int uid = Integer.parseInt(_uid);

        // 获取所有购物车信息
        List<ShoppingTrolley> shopping = cartDao.findByUid(uid);

        // 添加到购买记录中
        for (ShoppingTrolley shop : shopping) {
            purchaseDao.add(shop);
        }

        // 删除购物车记录
        cartDao.removeByUid(uid);
    }

    public List<Purchase> findAll(String uid) {
        return purchaseDao.findByUid(Integer.parseInt(uid));
    }
}
