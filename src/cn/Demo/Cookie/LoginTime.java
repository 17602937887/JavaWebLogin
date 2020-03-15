package cn.Demo.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/loginTime")
public class LoginTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();
        String date = null;
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("lastTime")){
                    date = cookie.getValue();
                    break;
                }
            }
        }
        if(date == null){
            response.getWriter().write("<h1>这是你首次登陆!</h1>");
        } else {
            response.getWriter().write("<h1>上次登陆时间:" + URLDecoder.decode(date, "utf-8") + "</h1>");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        String lastTime = sdf.format(new Date());
        Cookie cookie = new Cookie("lastTime", URLEncoder.encode(lastTime, "utf-8"));
        cookie.setMaxAge(30 * 24 * 60 * 60);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
