package servlet;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user != null && user.getRole().equals("admin")) {
            chain.doFilter(req, resp);
        } else if(user!=null) {
            httpServletResponse.sendRedirect("/user");
        }else {
            httpServletResponse.sendRedirect("/");
        }
    }
}
