package cn.Demo.dao;

import cn.Demo.JdbcUtils.JDBCUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/checkUsername")
public class checkUsername extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json, charset=utf-8");
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDatasource());
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user where user = ?", username);
        System.out.println(maps);

        Map<String, Boolean> val = new HashMap<>();
        if(maps.size() != 0){
            val.put("msg", true);
        } else { // 当前用户名存在 不可以注册
            val.put("msg", false);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(val);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
