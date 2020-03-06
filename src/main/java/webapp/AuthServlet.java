package webapp;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class AuthServlet extends HttpServlet {

    @Inject
    private ExampleBin exampleBin;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Login: " + exampleBin.getLogin());
        resp.getWriter().append("\r\nPassword: " + exampleBin.getPassword());

    }
}
