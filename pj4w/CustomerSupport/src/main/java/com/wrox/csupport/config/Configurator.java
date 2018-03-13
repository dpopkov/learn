package com.wrox.csupport.config;

import com.wrox.csupport.filters.AuthenticationFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Configurator implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        FilterRegistration.Dynamic registration = context.addFilter(
                "authenticationFilter", new AuthenticationFilter()
        );
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null, false,
                "/sessions", "/tickets");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // empty body
    }
}
