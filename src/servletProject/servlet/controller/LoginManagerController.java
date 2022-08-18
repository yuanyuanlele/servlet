package servletProject.servlet.controller;

import servletProject.enity.Manager;
import servletProject.service.ManagerService;
import servletProject.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/loginmanager")
public class LoginManagerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String inputVcode=req.getParameter("inputVcode");
        String codes=(String) req.getSession().getAttribute("codes");
        if (inputVcode!=null&&inputVcode.equals(codes)){
            ManagerService managerService=new ManagerServiceImpl();
            Manager manager=managerService.login(username,password);
            if (manager!=null){
                HttpSession session= req.getSession();
                session.setAttribute("manager",manager);
                resp.sendRedirect("/Myservlet_war_exploded/showallcontroller");
            }else {
                System.out.println(0);
                resp.sendRedirect("/Myservlet_war_exploded/loginmanager.html");
            }
        }else{
            resp.sendRedirect("/Myservlet_war_exploded/loginmanager.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
