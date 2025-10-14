package com.celebrato.backend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://celebretoevents.netlify.app") // your Netlify frontend URL
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*");
    }
}
