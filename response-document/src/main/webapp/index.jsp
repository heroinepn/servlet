<%--
  这里提交的路径，需要找到项目的路径.
  ${pageContext.request.contextPath}代表当前项目
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载</title>
    <h1>下载文件</h1>
    <h1>图片验证码</h1>
    <h1>重定向</h1>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"></br>
    密码： <input type="password" name="password"><br>
    <input type="submit">


</form>

</body>
</html>
