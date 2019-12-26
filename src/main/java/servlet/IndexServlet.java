package servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    UserService service = UserService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user;
        if ((user = service.authUser(email, password)) != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/admin");
        } else {
            response.sendRedirect("/index");
        }
        // service.addUser(new User(password, email));
        //  response.sendRedirect("/index");
    }
}
