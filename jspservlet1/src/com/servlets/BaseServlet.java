package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String methodName = request.getParameter("method");
        System.out.println("客户端传递过来的参数是："+methodName);
        //创建一个反射对象：它代表一个类的某个方法
        Method method=null;
        //通过反射获取请求对象所在类的那个方法：获取以后采用反射的方法来调用，不能用switch
        try {
            method=this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            //开放对私有方法的访问
            method.setAccessible(true);
            //通过反射对象调用方法并接收返回值
            String str=(String) method.invoke(this, request,response);
            if(str!=null && !str.trim().isEmpty()){
                String[] split = str.split(":");
                if(split[0].equals("f")){
                    System.out.println("/"+split[1]);
                    request.getRequestDispatcher("/"+split[1]).forward(request, response);
                }else if(split[0].equals("r")){
                    System.out.println(split[1]);
                    response.sendRedirect(split[1]);
                }
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
