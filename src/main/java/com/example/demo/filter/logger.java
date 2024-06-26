package com.example.demo.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class logger implements Filter {

    private static final Logger log = Logger.getLogger(logger.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        String uri = httpServletRequest.getRequestURI();
        String query = httpServletRequest.getQueryString();
        System.out.println("id " + httpServletRequest.getPathTranslated());
        log.info("Request: " + method + " " + uri); // Ghi nhật ký thông tin chi tiết
        log.info("Query: " + query);
        String idp = httpServletRequest.getParameter("id");
        if (idp != null){
            try {
                Integer.parseInt(idp);
            } catch (NumberFormatException e) {
                // Trả về phản hồi lỗi
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_BAD_REQUEST, "Tham số id không hợp lệ");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
        }
}

