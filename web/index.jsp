<%--
  Created by IntelliJ IDEA.
  User: Hang_ccccc
  Date: 2020/3/12
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<form action="/login/login" method="post">
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
          <input type="button" value="显示密码" id="button">
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
</script>
</body>
</html>
