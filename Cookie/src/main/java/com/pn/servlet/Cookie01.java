package com.pn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//保存用户上一次访问的时间
public class Cookie01 extends HttpServlet {
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
                if (cookie.getName().equals("Time")){
                    //获取cookie的值
                    cookie.getValue();
                    //变毫秒再转换
                    long Time=Long.parseLong(cookie.getValue());
                    Date date=new Date(Time);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("第一次访问");
        }
        //服务给客户端响应一个cookie
        Cookie cookie = new Cookie("Time",System.currentTimeMillis()+"");
        //添加有效期一天，默认关闭游览器生命周期结束
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
