package com.example.book.web.servlet;

import com.example.book.service.PurchaseService;
import com.example.book.service.impl.PurchaseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/purchase/*")
public class PurchaseServlet extends BaseServlet{
    private PurchaseService service = new PurchaseServiceImpl();

    // 一键购买
    public void buyAll(HttpServletRequest request, HttpServletResponse response){
        String uid = request.getParameter("uid");
        service.buyAll(uid);

        printObj("----purchase/buyAll", uid);
    }
}
