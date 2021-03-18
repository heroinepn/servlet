<%--
  Created by IntelliJ IDEA.
  User: heroine
  Date: 2021/2/28
  Time: 10:10 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<h1>登陆</h1>
<h2>获取参数，请求转发</h2>
<div style="text-align: center"></div>
<%--路径请求--%>
<%--${pageContext.request.contextPath}是JSP取得绝对路径的方法，等价于<%=request.getContextPath()%> 。
也就是取出部署的应用程序名或者是当前的项目名称

比如我的项目名称是设置为空在浏览器中输入为http://localhost:8080/项目名/a.jsp ${pageContext.request.contextPath}或<%=request.getContextPath()%>取出来的就是/demo1,而"/"代表的含义就是http://localhost:8080

故有时候项目中这样写${pageContext.request.contextPath}/a.jsp--%>
<form action="${pageContext.request.contextPath}/login "method="post">
    用户名：<input type="text" name="username"><br>
    密码： <input type="password" name="password"><br>
    爱好：
    <input type="checkbox" name="vv" value="代码">代码
    <input type="checkbox" name="vv" value="画画">画画
    <input type="checkbox" name="vv" value="读书">读书
    <input type="checkbox" name="vv" value="刷博">刷博<br>
    <input type="submit">
</form>
</body>
</html>
