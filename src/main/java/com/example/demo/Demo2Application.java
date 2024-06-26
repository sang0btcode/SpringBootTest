package com.example.demo;

import com.example.demo.filter.logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }


    @Bean
    public FilterRegistrationBean<logger> loggingFilterRegistration() {
        FilterRegistrationBean<logger> registration = new FilterRegistrationBean<>();
        registration.setFilter(new logger());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
