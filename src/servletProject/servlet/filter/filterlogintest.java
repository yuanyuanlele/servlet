package servletProject.servlet.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/filterlogintest")
public class filterlogintest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+password);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
