package com.example.book.web.servlet;

import com.example.book.domain.ResultInfo;
import com.example.book.domain.ShoppingTrolley;
import com.example.book.service.ShoppingTrolleyService;
import com.example.book.service.impl.ShoppingTrolleyServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/shopping/*")
public class ShoppingTrolleyServlet extends BaseServlet {
    private ShoppingTrolleyService service = new ShoppingTrolleyServiceImpl();

    // 添加一条购物车记录，需要 uid，bid，price
    public void add(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> map = request.getParameterMap();

        // 封装数据
        ShoppingTrolley cart = new ShoppingTrolley();
        try {
            BeanUtils.populate(cart, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        service.add(cart);
        printObj("----shopping/add", cart);
    }

    // 根据 uid 查询购物车记录
    public void findByUid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        List<ShoppingTrolley> carts = service.findByUid(uid);

        writeValue(carts, response);
        printList("----shopping/findByUid", carts);
    }

    // 根据 bid 和 uid 删除
    public void remove(HttpServletRequest request, HttpServletResponse response) {
        String sid = request.getParameter("sid");
        service.remove(sid);

        printObj("----shopping/remove", sid);
    }

    public void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        List<ShoppingTrolley> carts = service.findByUid(uid);
        ResultInfo info = new ResultInfo();

        if (carts != null && carts.size() != 0) {
            info.setFlag(true);
            info.setData(carts.size());
        } else {
            info.setFlag(false);
        }
        writeValue(info, response);

        printObj("----shopping/find", info);
    }
}
