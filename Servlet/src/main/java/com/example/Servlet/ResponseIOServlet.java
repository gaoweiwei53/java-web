package com.example.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseIOServlet", value = "/ResponseIOServlet")
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(response.getCharacterEncoding()); //默认的字符集是ISO-8859-1，不支持在中文

        // 方法1:
//        // 设置服务器的字符编码为UTF-8
//        response.setCharacterEncoding("UTF-8");
//
//        //设置浏览器的字符编码为UTF-8
//        response.setHeader("Content-Type","text/html; charset= UTF-8");

        // 方法2:
        // 同时设置服务器和浏览器的字符编码格式，此方法一定要在获取流对象之前调用
        response.setContentType("text/html; charset= UTF-8");

        // 往客户端回传数据
//        response.getOutputStream();
        PrintWriter writer = response.getWriter();
        writer.write("hello motherfucker");
        writer.write("你好");

    }
}
