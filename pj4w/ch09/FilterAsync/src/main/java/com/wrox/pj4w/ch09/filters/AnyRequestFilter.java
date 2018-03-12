package com.wrox.pj4w.ch09.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class AnyRequestFilter implements Filter {
    private String name;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getFilterName();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logInfo("Entering " + name + ".doFilter().");
        chain.doFilter(
                new HttpServletRequestWrapper((HttpServletRequest) request),
                new HttpServletResponseWrapper((HttpServletResponse) response)
        );
        if (request.isAsyncSupported() && request.isAsyncStarted()) {
            AsyncContext context = request.getAsyncContext();
            logInfo("Leaving " + name + ".doFilter(), async " +
                    "context holds wrapped request/response = " +
                    !context.hasOriginalRequestAndResponse());
        } else {
            logInfo("Leaving " + name + ".doFilter().");
        }
        System.out.println();
    }

    @Override
    public void destroy() {
        // empty body
    }

    private void logInfo(String s) {
        System.out.println(threadName() + s);
    }

    private synchronized String threadName() {
        return Thread.currentThread().getName() + ": ";
    }
}
