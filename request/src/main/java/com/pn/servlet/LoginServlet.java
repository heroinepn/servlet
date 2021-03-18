package com.pn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String username= req.getParameter("username");
      String password= req.getParameter("password");
      String[] like= req.getParameterValues("vv");
        System.out.println("===============");
        System.out.println(username+":"+password);
        req.setCharacterEncoding("utf-8");
        //打印选项
        System.out.println(Arrays.toString(like));

        // 转发this.getServletContext();
        System.out.println("路径");
        //request.getContextPath()应该是得到项目的名字，如果项目为根目录，
        // 则得到一个""，即空的字条串。
        // 如果项目为abc, <%=request.getContextPath()% >
        // 将得到abc，服务器端的路径则会自动加上
        System.out.println(req.getContextPath());
        //通过请求转发
        //这里的/代表当前的web应用
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
