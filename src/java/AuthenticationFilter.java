import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String loginURI = httpRequest.getContextPath() + "/index.html";
        String loginServletURI = httpRequest.getContextPath() + "/LoginServlet";

        boolean loggedIn = session != null && session.getAttribute("username") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean loginServletRequest = httpRequest.getRequestURI().equals(loginServletURI);

        if (loggedIn || loginRequest || loginServletRequest) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(loginURI);
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // Filter initialization if needed
    }

    @Override
    public void destroy() {
        // Filter destruction if needed
    }
}
