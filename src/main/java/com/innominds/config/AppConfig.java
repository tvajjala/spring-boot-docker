package com.innominds.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        super.addViewControllers( registry );
        registry.addRedirectViewController( "/", "/env" );
    }

    @Bean
    ServletRegistrationBean h2servletRegistration() {
        final ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet() );
        registrationBean.addUrlMappings( "/console/*" );
        return registrationBean;
    }
}
