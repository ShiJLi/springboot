package com.shijl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 配置springboot使用原生的servlet
 * 1.编写MyServlet类，继承HttpServlet
 * 2、在启动类配置servlet的包扫描
 * @ServletComponentScan(basePackages = "com.shijl")
 *
 * 不会经过springboot的拦截器
 */
//@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("6666");
    }
}
