package com.yukong.chapter6.service.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qinjunjie
 * @projectName testDemo
 * @title: Servlet
 * @description: HttpServletRequest和HttpServletResponse
 * @date 2019/7/2016:47
 */
public class Servlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url=request.getRequestURL().toString();
        System.out.println("url--->"+url);

        String uri=request.getRequestURI();
        System.out.println("uri--->"+uri);

        String qs=request.getQueryString();
        System.out.println("请求参数："+qs);

        String method=request.getMethod();
        System.out.println("请求参数"+method);

        String protocol=request.getProtocol();
        System.out.println("请求协议："+protocol);

        String context=request.getContextPath();
        System.out.println("请求站点名："+context);
    }
}
