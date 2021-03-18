package com.pn.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        //2.下载文件
        //             ·获取下载文件的路径
      String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/servlet原理.png");
      //String realPath ="/Users/heroine/IdeaProjects/java-2-servlet/response-document/target/classes/servlet原理.png";
        System.out.println("获取下载的路径"+realPath);

        //             ·获取下载文件名
        String filename=realPath.substring(realPath.lastIndexOf("/")+1);
       // String filename=realPath.substring(0);
        //             ·浏览器支持下载
        resp.setHeader("content-type", "image/png");//文件类型
        resp.setHeader("Content-Disposition","attachment;filename"+ URLEncoder.encode(filename,"UTF-8"));
        //          3.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //          4.创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
        //          5.获取OutpurStream对象
        ServletOutputStream out = resp.getOutputStream();
        //          6.将FileOutStream流写入到buffer缓冲区
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }//          7.使用OutputStream将缓冲区中的数据输出到客户端
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
