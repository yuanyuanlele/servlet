package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class httpservlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        System.out.println("这是get");
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws  ServletException,IOException
    {
        System.out.println("这是post");
    }
}
