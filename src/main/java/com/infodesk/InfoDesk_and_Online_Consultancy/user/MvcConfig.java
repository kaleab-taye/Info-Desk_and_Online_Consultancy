package com.infodesk.InfoDesk_and_Online_Consultancy.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/").setViewName("index");
        registry.addViewController("/list").setViewName("user-page");
        registry.addViewController("/admin").setViewName("admin-page");
        // registry.addViewController("/shipper_home").setViewName("shipper_home");
    }
 
}
