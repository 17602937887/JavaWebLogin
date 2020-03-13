package cn.Demo.Servlet;

import cn.Demo.JdbcUtils.JDBCUtils;
import cn.Demo.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/show")
public class Show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());
        List<User> query = template.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        response.getWriter().write("<table border='1' bgcolor='#7fccde'>");
        response.getWriter().write("<tr>");
        response.getWriter().write("<td>");
        response.getWriter().write("ID:");
        response.getWriter().write("</td>");
        response.getWriter().write("<td>");
        response.getWriter().write("user:");
        response.getWriter().write("</td>");
        response.getWriter().write("<td>");
        response.getWriter().write("gender:");
        response.getWriter().write("</td>");
        response.getWriter().write("<td>");
        response.getWriter().write("name:");
        response.getWriter().write("</td>");
        response.getWriter().write("<td>");
        response.getWriter().write("join_date:");
        response.getWriter().write("</td>");
        response.getWriter().write("</tr>");
        String bgcolor = "#fa5a5a";
        for(User user : query){
            response.getWriter().write("<tr" + " bgcolor = '" + bgcolor + "'>");
            response.getWriter().write("<td>");
            response.getWriter().write(user.getId().toString());
            response.getWriter().write("</td>");
            response.getWriter().write("<td>");
            response.getWriter().write(user.getUser());
            response.getWriter().write("</td>");
            response.getWriter().write("<td>");
            response.getWriter().write(user.getGender());
            response.getWriter().write("</td>");
            response.getWriter().write("<td>");
            response.getWriter().write(user.getName());
            response.getWriter().write("</td>");
            response.getWriter().write("<td>");
            response.getWriter().write(user.getJoin_date().toString());
            response.getWriter().write("</td>");
            response.getWriter().write("</tr>");
            if(bgcolor.equals("#fa5a5a")){
                bgcolor = "#cb99c5";
            } else {
                bgcolor = "#fa5a5a";
            }
        }
        response.getWriter().write("</table>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
