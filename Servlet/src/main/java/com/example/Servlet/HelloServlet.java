package com.example.Servlet;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        // 测试ServletContext的功能
        ServletContext context = getServletContext();
        System.out.println("当前工程路径：" + context.getContextPath());
        System.out.println("绝对路径是：" + context.getRealPath("/"));
        System.out.println("URI --> "+request.getRequestURI());
        System.out.println("URL --> "+request.getRequestURL());
        System.out.println(request.getRemoteAddr());
        // 很重要的方法，可以获取请求的参数
        System.out.println(request.getParameter("username"));

        // 可以获取多值
        System.out.println(request.getParameterValues("username"));
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Post请求某个参数若是中文, 设置请求字体为“UTF-8”
        // 获取请求参数之前才有用
        request.setCharacterEncoding("UTF-8");

        // 请求转发，向Servlet2请求资源
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Servlet2");
        requestDispatcher.forward(request,response);

    }

    public void destroy() {
    }
}