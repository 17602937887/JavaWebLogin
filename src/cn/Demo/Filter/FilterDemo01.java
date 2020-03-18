package cn.Demo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo1过滤器被执行了!!!");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("filterDemo02回来了");
    }

    @Override
    public void destroy() {

    }
}
