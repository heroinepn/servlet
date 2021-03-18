package com.pn.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            /*
            this.getInitParameter() 初始化参数
            this.getServletConfig() servlet配置
            this.getServletContext()  servlet上下文
            ServletContext ：web容器在启动的时候，它会为每个web程序都创建一个对应的ServletContext对象，它代表了当前的web应用

             */
            ServletContext context=this.getServletContext();
            String username="pn";//数据
            context.setAttribute("username",username);//将一个数据保存在 ServletContext中，名字，值为 username
            System.out.println("hello");
        }



}
