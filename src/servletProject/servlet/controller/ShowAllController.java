package servletProject.servlet.controller;

import servletProject.enity.Admin;
import servletProject.enity.Manager;
import servletProject.service.AdminService;
import servletProject.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value ="/showallcontroller")
public class ShowAllController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manager manager=null;
        HttpSession session= req.getSession();
        manager=(Manager) session.getAttribute("manager");
        if (manager!=null) {
            AdminService adminService = new AdminServiceImpl();
            List<Admin> list = adminService.showAllAdmin();
            req.setAttribute("admins", list);
            req.getRequestDispatcher("/showalljsp").forward(req, resp);
        }else {
            resp.sendRedirect("/Myservlet_war_exploded/loginmanager.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
