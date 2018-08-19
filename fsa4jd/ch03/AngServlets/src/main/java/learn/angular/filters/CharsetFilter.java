package learn.angular.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.Random;

public class CharsetFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Preprocessing

        if (new Random().nextBoolean()) {
            chain.doFilter(request, response);
        }

        // Postprocessing
    }

    @Override
    public void destroy() {

    }
}
