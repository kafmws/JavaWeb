package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/bbb/*")
public class BBBFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object right = req.getSession().getAttribute("right");
        if(!"bbb".equals(right)){
            res.sendRedirect("/bcm/index.jsp");
            return;
        }
        System.out.println("in BBBFilter");
        chain.doFilter(req,res);
    }
}
