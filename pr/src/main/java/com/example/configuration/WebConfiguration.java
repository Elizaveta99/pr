package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration /*implements WebMvcConfigurer*/ extends WebMvcConfigurerAdapter {

    private static final int MAX_AGE = 3600;

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*" /*"http://localhost:4200"*/ /*"http://localhost:8080/"*/)
                .allowedHeaders("*" /*"http://localhost:4200"*/ /*"http://localhost:8080/"*/)
                .allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS")
                .allowCredentials(false).maxAge(MAX_AGE);
    }
}
