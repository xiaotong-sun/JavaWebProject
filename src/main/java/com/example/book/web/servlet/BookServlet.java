package com.example.book.web.servlet;

import com.example.book.domain.Book;
import com.example.book.domain.ResultInfo;
import com.example.book.service.BookService;
import com.example.book.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet("/book/*")
@MultipartConfig
public class BookServlet extends BaseServlet {
    private BookService service = new BookServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Book> books = service.findAll();
        writeValue(books, response);

        System.out.println("----book/findAll");
        for (Book book : books) {
            System.out.println("\t" + book);
        }
        System.out.println("----book/findAll\n");
    }

    public void findRangeByBid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bid = request.getParameter("bid");
        List<Book> bookList = service.findRangeByBid(bid);

        writeValue(bookList, response);
        printList("----book/findRangeByBid", bookList);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) {
        String bid = request.getParameter("bid");
        service.remove(bid);

        printObj("----book/remove", bid);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

        // 封装数据
        Map<String, String[]> map = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //获取/pic的物理路径
        String path = getServletContext().getRealPath("/img");
        Part part = request.getPart("img");

        if (part.getSize() != 0) {
            String[] split = part.getSubmittedFileName().split("\\.");
            String suffix = split[split.length - 1];

            String pic = UUID.randomUUID() + "." + suffix;
            String filePath = path + "/" + pic;

            part.write(filePath);
            book.setPicture(pic);
        }
        service.add(book);
        printObj("----book/add", book);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bid = request.getParameter("bid");
        String newPrice = request.getParameter("newPrice");
        String newNum = request.getParameter("newNum");

        ResultInfo info = new ResultInfo();
        if (service.update(bid, newNum, newPrice)) {
            info.setFlag(true);
        } else {
            info.setFlag(false);
            info.setErrorMsg("书籍编号不存在");
        }
        writeValue(info, response);
        printObj("----book/update", info);
    }
}
