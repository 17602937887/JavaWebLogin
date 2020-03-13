<%--
  Created by IntelliJ IDEA.
  User: Hang_ccccc
  Date: 2020/3/12
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/login/register" method="post">
    <p><font color="red">*</font>为必填项</p>
    <table>
        <tr>
            <td>
                <font color="red">*</font>
                <font face="楷体">用户名: </font>
            </td>
            <td>
                <input type="text" name="user" placeholder="请输入账号"> <br>
            </td>
        </tr>
        <tr>
            <td>
                <font color="red">*</font>
                <font face="楷体">密 码: </font>
            </td>
            <td>
                <input type="password" name="password" id="inputPassword" placeholder="请输入密码">
                <input type="button" value="显示密码" id="button"> <br>
            </td>
        </tr>
        <tr>
            <td>
                <font face="楷体">性 别: </font>
            </td>
            <td>
                <input type="radio" name="gender" value="男" checked> 男
                <input type="radio" name="gender" value="女"> 女 <br>
            </td>
        </tr>
        <tr>
            <td>
                <font color="red">*</font>
                <font face="楷体">真实姓名: </font>
            </td>
            <td>
                <input type="text" name="name" placeholder="请输入姓名"> <br>
            </td>
        </tr>
        <tr>
            <td rowspan="2">
                <input type="submit" value="提交" style="width: 100px;">
            </td>
        </tr>
    </table>
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
