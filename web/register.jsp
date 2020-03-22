<%--
  Created by IntelliJ IDEA.
  User: Hang_ccccc
  Date: 2020/3/12
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="500.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
           $("#user").blur(function () {
               $.get("${pageContext.request.contextPath}/checkUsername", {"username": $(this).val()}, function (data) {
                   if(data.msg){
                       $("#userImg").prop("src", "${pageContext.request.contextPath}/img/no.png");
                       $("#ImgDiv").css("display", '');
                   } else {
                       $("#userImg").prop("src", "${pageContext.request.contextPath}/img/yes.png");
                       $("#ImgDiv").css("display", '');
                   }
               });
           });
           $("#user").focus(function () {
               console.log("获得焦点");
               $("#ImgDiv").css("display", "none");
           });
        });
    </script>
    <style>
        #ImgDiv{
            border: red solid 1px;
            width:60px;
            height: 40px;
            padding:0px;
        }
        #ImgDiv img{
            border: green solid 1px;
            width:100%;			/* ... */
            height:100%;		/* ... */
            display:block;	/* ... */
        }
    </style>
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
                <input type="text" name="user" placeholder="请输入账号" id="user">
                <br>
            </td>
            <td>
                <div style="width: 20px; height: 20px; display: none" id="ImgDiv">
                    <img src="" id="userImg" style=" size: auto">
                </div>
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
