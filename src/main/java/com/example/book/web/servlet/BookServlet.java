package com.example.book.web.servlet;

import com.example.book.domain.Book;
import com.example.book.service.BookService;
import com.example.book.service.impl.BookServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/book/*")
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
}
