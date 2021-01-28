package com.example.Servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "Filter_01")
public class Filter_01 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i'm coming!");
    }

    public void destroy() {
        System.out.println("i'm done");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        // 必须要写
        chain.doFilter(request, response);
    }
}
