<%--
  Created by IntelliJ IDEA.
  User: Hang_ccccc
  Date: 2020/3/16
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>服务器错误</title>
</head>
<body>
<%
    exception.printStackTrace();
%>
<img src="/login/img/500.jpg" id="img" style="height: 100%; height: 100%">
<script>
    var img = document.getElementById("img")
    img.onclick = function () {
        location.href = "/login/index.jsp";
    }
</script>
</body>
</html>
