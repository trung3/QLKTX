//package com.QLKTX;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//	@Bean
//    public FilterRegistrationBean<AuthFilter> authFilter() {
//        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new AuthFilter()); // Đăng ký filter
//        registrationBean.addUrlPatterns("/*"); // Áp dụng filter cho tất cả các đường dẫn
//
//        return registrationBean;
//    }
//}
