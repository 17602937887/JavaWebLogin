<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Hang_ccccc
  Date: 2020/3/12
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="500.jsp" %>
<html>
<head>
    <title>登陆页面</title>
  <style>
    tr{
      height: 40px;
    }
    td{
      width: 70px;
    }
  </style>
</head>
<body>
<%
  String checkImgCodeError = (String) session.getAttribute("checkImgCodeError");
  if("true".equals(checkImgCodeError)){
    out.print("<script>alert('验证码错误了!')</script>");
    session.removeAttribute("checkImgCodeError");
  }
  String checkPasswordError = (String) session.getAttribute("checkPasswordError");
  if("true".equals(checkPasswordError)){
    out.print("<script>alert('用户名或密码错误!')</script>");
    session.removeAttribute("checkPasswordError");
  }
%>
<form action="${pageContext.request.contextPath/login}" method="post">
    <table>
      <tr>
        <td>
          <font>用户名: </font>
        </td>
        <td>
          <input type="text" name="user" placeholder="请输入用户名">
        </td>
      </tr>
      <tr>
        <td>
          <font>密码: </font>
        </td>
        <td>
          <input type="password" name="password" id="inputPassword" placeholder="请输入密码">
        </td>
        <td>
          <input type="button" value="显示密码" id="button">
        </td>
      </tr>
      <tr>
        <td>
          <font>验证码:</font>
        </td>
        <td>
          <input type="text" name="checkImgCode">
        </td>
        <td>
          <img src= "${pageContext.request.contextPath}/checkCodeServlet" id="checkImgCode">
        </td>
      </tr>
      <tr>
        <td rowspan="2">
          <input type="submit" value="登陆">
        </td>
      </tr>
    </table>
</form>
<button><a href="/login/register.jsp">注册</a></button>
<form action="/login/show">
  <button type="submit">显示所有用户</button>
</form>
<script>
    var flag = false;
    document.getElementById("button").onclick = function () {
        if (flag) {
            document.getElementById("inputPassword").setAttribute("type", "password");
            document.getElementById("button").setAttribute("value", "显示密码");
        } else {
            document.getElementById("inputPassword").setAttribute("type", "text");
            document.getElementById("button").setAttribute("value", "隐藏密码");
        }
        flag = !flag;
    }
    var checkImgCode = document.getElementById("checkImgCode");
    checkImgCode.onclick = function () {
      checkImgCode.setAttribute("src", "/login/checkCodeServlet?time=" + new Date().getTime());
    }
</script>
<%
  System.out.println("index.jsp......");
%>
</body>
</html>
