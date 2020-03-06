package webapp.Controllers.Login;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/pages/*")
public class LoginFilter implements Filter {
    @Inject
    private AuthBean authBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpServletRequest request1 = (HttpServletRequest) request;
        if (authBean.isLoggedIn()) {
            chain.doFilter(request,response);
            return;
        }
        authBean.setRequestedPage(request1.getRequestURI());


        response1.sendRedirect(request1.getContextPath() + "/Login.xhtml");

    }

    @Override
    public void destroy() {

    }
}
