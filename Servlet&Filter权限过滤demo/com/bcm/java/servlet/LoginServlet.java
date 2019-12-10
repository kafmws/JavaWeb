package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
//        req.getSession().removeAttribute("right");
        if("aaa".equals(name) && "aaa".equals(pwd)){
            req.getSession().setAttribute("right","aaa");
        }else if("bbb".equals(name) && "bbb".equals(pwd)){
            req.getSession().setAttribute("right","bbb");
        }else {
            resp.sendRedirect("login.html");
            return;
        }
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
