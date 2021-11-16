package com.example.book.web.servlet;

import com.example.book.domain.Purchase;
import com.example.book.service.PurchaseService;
import com.example.book.service.impl.PurchaseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/purchase/*")
public class PurchaseServlet extends BaseServlet {
    private PurchaseService service = new PurchaseServiceImpl();

    // 一键购买
    public void buyAll(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        service.buyAll(uid);

        printObj("----purchase/buyAll", uid);
    }

    // 通过 uid 查询购买记录
    public void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        List<Purchase> purchases = service.findAll(uid);

        writeValue(purchases, response);
        printList("----purchase/search", purchases);
    }
}
