package com.nizar.azzam.servlet.listener.servlet;

import com.nizar.azzam.conf.DatabaseService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class InitConnectionDb implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("Webapp started!");
        ServletContext context = servletContextEvent.getServletContext();
        log.info("web deployed");
        context.setAttribute("db", new DatabaseService("root", "root", "jdbc:mysql://localhost:3306/testing"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("Webapp destroyed!");
    }
}
