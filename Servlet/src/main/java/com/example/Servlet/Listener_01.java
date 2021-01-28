package com.example.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// 统计网站在线人数：统计Session
@WebListener
public class Listener_01 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public Listener_01() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if (onlineCount==null){
            onlineCount = Integer.valueOf(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = Integer.valueOf(count+1);

        }
        servletContext.setAttribute("onlineCount",onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");

        if (onlineCount==null){
            onlineCount = Integer.valueOf(0);
        } else {
            int count = onlineCount.intValue();
            onlineCount = Integer.valueOf(count - 1);

        }
        servletContext.setAttribute("onlineCount",onlineCount);

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
