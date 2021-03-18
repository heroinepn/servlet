package com.pn.servlet;

import com.pn.servlet.enti.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Session01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到Session
        HttpSession session=req.getSession();
        //给Session存东西
//        session.setAttribute("name","pn");
        session.setAttribute("name",new Person("pn",1));

        //获取session的id
       String id= session.getId();
       //判断是不是新的session
        if (session.isNew()){
            resp.getWriter().write("new"+id);
        }else{
//            是服务端通过getwriter方法 获得流 让 PrintWriter 接收,
//                    然后out.wirte ("");可以向浏览器输出东西
            PrintWriter out=resp.getWriter();
            out.write("not new"+id);

        }
        //Session创建的时候做了什么
//        Cookie cookie=new Cookie("JSESSIONID",id);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
