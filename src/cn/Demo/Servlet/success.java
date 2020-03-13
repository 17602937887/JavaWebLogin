package cn.Demo.Servlet;

import cn.Demo.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success")
public class success extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("来到了success页面!!!!");
        User user = (User) request.getAttribute("user");
        if(user == null){
            response.sendRedirect("/index.jsp");
        } else {
            response.setContentType("text/html; charset=utf8");
            response.getWriter().write(show(user));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    private static String show(User user){
        return
        "<a>欢迎你:</a>" +
        "<font color='red' size=16px>" + user.getName() + "</font>" +
        "<br> <a>性别:</a>" +
        "<font color='red' size=16px>" + user.getGender() + "</font>" +
        "<br> <a>注册时间:</a>" +
        "<font color='red' size=16px>" + user.getJoin_date() + "</font>";
    }
}
