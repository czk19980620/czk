package com.servlets;

import com.dao.TBookDAO;
import com.pojo.TBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TBookServlet",urlPatterns = "/TBookServlet")
public class TBookServlet extends BaseServlet {
    protected String  selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TBook> list = TBookDAO.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("allBook",list);
        return "r:selectAll.jsp";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
