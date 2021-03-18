web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
version="3.1"
metadata-complete="true">
</web-app>
``````
如果配置文件无法导出或者生效在pom.xml中build配置resource
读取文件会被打包到WEB-INF下的classes classpath路径
```xml
<build>
    <resource>
        <directory>src/main/resource</directory>
        <includes>
            <include>**/*.properties</include>
            <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
    </resource>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.properties</include>
            <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering> 
    </resource>
</build>
```
HttpServletResponse
```txt

web服务器接收到客户端的http请求，针对这个请求分别创建一个代表请求的对象，代表响应的一个HttpServletResponse
    ·如果要获取客户端请求过来的参数：找HttpServletRequest
    ·如果要给客户端响应一些信息：找HttpServletResponse
  常见应用：1.向浏览器输出信息
          2.下载文件
             ·获取下载文件的路径
             ·获取下载文件名
             ·浏览器支持下载
          3.获取下载文件的输入流
          4.创建缓冲区
          5.获取OutpurStream对象
          6.将FileOutStream流写入到buffer缓冲区
          7.使用OutputStream将缓冲区中的数据输出到客户端
   ```
**重定向和转发的区别**
相同点：页面都会实现跳转
不同点：请求转发的时候，url不会产生变化
       重定向的时候，url栏会发生变化
HttpServletRequest 
 1.请求转发
 2.获取前端传递的参数
Cookie Session
**保存会话的两种技术**
cookie
  客户端技术（响应，请求）
  1.从请求中拿到cookie信息
  2.服务器响应给客户端cookie
从服务器中得到的Cookie在网页关闭前一直携带

Session，登记唯一的 Session ID，用户拿到Session ID，服务器中的
Session可以存储东西，比如个人信息
```txt
    1.获得cookie
    2.获得key
    3.获得value
    4.新建一个cookie
    5.设置cookie的有效期
    6.响应一个cookie给客户端
```
   **cookie一般会保存在本地用户目录下 appdata**
**cookie上限细节问题**
一个cookie只能保存一个信息
一个浏览器上限300

session
    服务器技术，保存用户信息。
一个Session独占一个浏览器，只要浏览器没有关闭，这个Session就存在。
解决乱码问题
```txt
req.setCharacterEncoding("utf-8");
resp.setCharacterEncoding("utf-8");
resp.setContentType("text/html;charset=utf-8");
```
得到Session
给Session存东西
**Session和Cookie的区别**
Cookie是把用户的数据写给用户的浏览器，浏览器保存（可以保存多个）
Session把用户的数据写到用户独占Session中，服务器端保存（保存重要信息，减少服务器资源浪费）
Session对象由服务器创建。