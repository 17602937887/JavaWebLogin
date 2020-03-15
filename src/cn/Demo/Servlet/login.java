package cn.Demo.Servlet;

import cn.Demo.dao.UserDao;
import cn.Demo.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            user = null;
        }
        user = UserDao.login(user);
        // 登陆失败
        if(user == null){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("checkLogin", "success");
            response.sendRedirect(request.getContextPath() + "/loginSuccess.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
