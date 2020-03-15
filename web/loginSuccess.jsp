<%@ page import="cn.Demo.domain.User" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="cn.Demo.dao.UpdateLastTime" %><%--
  Created by IntelliJ IDEA.
  User: Hang_ccccc
  Date: 2020/3/15
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
<%
//     判断用户是直接输入登陆URL还是真实登陆
    String checkLogin = (String) session.getAttribute("checkLogin");
    if(!"success".equals(session.getAttribute("checkLogin"))){
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    User user = (User) session.getAttribute("user");
    System.out.println(user.getLastTime());
    if(user.getLastTime() == null){
        out.print("<h1>欢迎登陆:" + user.getName() + ",这是你首次登陆</h1>");
    } else {
        out.print("<h1>欢迎回来: " + user.getName() + ",上次登陆时间为" + user.getLastTime().toString().substring(0, 19) + "</h1>");
    }
    UpdateLastTime.updateLastTime(user);
%>
</body>
</html>
