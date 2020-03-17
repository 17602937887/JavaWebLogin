<%@ page import="cn.Demo.domain.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hang_ccccc
  Date: 2020/3/17
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有用户信息</title>
    <style>
        td, tr, th{
           align-content: center;
        }

    </style>
</head>
<body>
<table border="2" style="border-style: solid; border-color: greenyellow" align="center">
    <tr style="border-color: green;">
        <td>用户ID</td>
        <td>用户账号</td>
        <td>用户密码</td>
        <td>用户性别</td>
        <td>用户名字</td>
        <td>用户注册时间</td>
        <td>用户最后登录时间</td>
    </tr>
    <c:forEach items="${sessionScope.get('allUser')}" var="user" varStatus="s">
        <tr>
            <td>${user.id}</td>
            <td>${user.user}</td>
            <td>${user.password}</td>
            <td>${user.gender}</td>
            <td>${user.name}</td>
            <td>${user.join_date}</td>
            <td>${user.lastTime}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
