package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet1",urlPatterns = "/Servlet1")
@MultipartConfig
public class Servlet1 extends BaseServlet {
    protected String  uploadFiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part file1 = request.getPart("file1");
        String a = file1.getHeader("content-disposition");
        PrintWriter out = response.getWriter();
        out.print(a);
        file1.write("D:/a.txt");
        return null;
    }
}
