package com.pn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * maven web.xml环境为最新，结构搭建完成
 * 编写Servlet程序
 * 1.编写一个普通类
 * 2.实现Servlet接口默认HttpServlet,
 * 3.编写servlet映射,Java程序通过浏览器访问，而浏览器需要连接web服务器，所以需要在web服务器注册Servlet和浏览器能够访问的路径
 * 4.
 */
public class HelloServlet extends HttpServlet {
    //由于get或者post只是请求实现不同的方式，可以相互调用，业务逻辑都一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doGet方法");
        //ServletOutputStream outputStream = resp.getOutputStream();
        PrintWriter writer = resp.getWriter();//响应流
        writer.println("hi servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
