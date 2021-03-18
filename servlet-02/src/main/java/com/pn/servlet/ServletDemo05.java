package com.pn.servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletDemo05 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
       InputStream in= context.getResourceAsStream("/WEB-INF/classes/db.properties");//资源流 读取已编译
        Properties prop = new Properties();//读取资源
        prop.load(in);
       String user= prop.getProperty("username");
        String pass= prop.getProperty("password");
        resp.getWriter().println(user+";"+pass);


    }
}