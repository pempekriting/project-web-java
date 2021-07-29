package com.nizar.azzam.servlet.log;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoggingServletFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        log.info("Init servlet filter!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        log.info("request from: {hostname: {}, port: {}, httpMethod: {}, url: {}, requestDate:{}}",
                servletRequest.getRemoteHost(),
                servletRequest.getServerPort(),
                request.getMethod(),
                uri,
                new Date());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("Destroy servlet filter! ");
    }
}
