package com.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet", urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        CRUDDAO<Book1> cruddao = new CRUDDAO<>(Book1.class);
        Map<String,Object[]> map1 = new LinkedHashMap<>();
        map1.put("SELECT * FROM book1;",null);
        Map<Integer, List<Book1>> map = cruddao.executeQuery(map1);
        for (Map.Entry<Integer, List<Book1>> entry : map.entrySet()) {
            out.print(entry.getKey()+":");
            for (Book1 book1 : entry.getValue()) {
                out.println(book1);
            }
        }
    }
}
