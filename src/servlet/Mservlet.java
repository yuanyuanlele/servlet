package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class Mservlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }
    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("SADSDAASDAS");
        System.out.println(new Date());
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
