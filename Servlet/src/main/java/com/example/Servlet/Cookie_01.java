package com.example.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Cookie_01", value = "/Cookie_01")
// 获取上一次访问的时间
public class Cookie_01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset= UTF-8");

        PrintWriter writer = response.getWriter();
        // 服务器从客户端获取Cookie
        Cookie[] cookies = request.getCookies();
        // 判断cookie释放存在
        if (cookies != null){
            writer.write("你上一次访问的时间是");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 获取cookie的名字
                if (cookie.getName().equals("LastLoginTime")){
                    // 获取cookie里的值
                    long l = Long.parseLong(cookie.getValue());
                    Date date = new Date(l);
                    writer.write(date.toString());

                }
            }
        } else {
            writer.write("这是你第一次访问网站");
        }
        Cookie cookie = new Cookie("LastLoginTime",System.currentTimeMillis() +"");
        // 有效期为一天
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);
    }
}
