package com.example.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Session_01", value = "/Session_01")
public class Session_01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset= UTF-8");

        // 得到Session
        HttpSession session = request.getSession();

        // 给Session存东西
        session.setAttribute("name","alex");

        //获取Session ID
        String id = session.getId();

        // 判断是不是新创建的
        if (session.isNew()){
            response.getWriter().write("Session创建成功，ID:" + id );
        } else {
                response.getWriter().write("session已经在服务器中存在了，id：" + id);
        }

    }

}
