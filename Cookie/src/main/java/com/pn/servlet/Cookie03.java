package com.pn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

//保存用户上一次访问的时间
public class Cookie03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        //cookie,服务器从客户端获取
        Cookie[] cookies = req.getCookies();
        //判断是否存在
        if (cookies!=null){
            //存在
            out.write("上次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie= cookies[i];
                //获取cookie的名字
                if (cookie.getName().equals("name")){
                    //获取cookie的值
                    //out.write(cookie.getValue());
                    //解码
                    out.write(URLDecoder.decode(cookie.getValue(),"UTF-8"));
                }
            }
        }else{
            out.write("第一次访问");
        }
        //服务给客户端响应一个cookie
        Cookie cookie = new Cookie("name", URLEncoder.encode("三三", "utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}




