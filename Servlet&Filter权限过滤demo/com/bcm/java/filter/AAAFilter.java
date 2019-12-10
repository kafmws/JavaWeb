package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/aaa/*")
public class AAAFilter extends HttpFilter{

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object right = req.getSession().getAttribute("right");
        if(!"aaa".equals(right)){
            res.sendRedirect("/bcm/index.jsp");
            return;
        }
        System.out.println("in AAAFilter");
        chain.doFilter(req,res);
    }
}
