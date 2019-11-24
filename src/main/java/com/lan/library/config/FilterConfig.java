package com.lan.library.config;

import com.lan.library.Security.JwtAuthenticationFilter;
import com.lan.library.handler.filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author Xiang Lan
 * Created on 2019-07-18 11:15
 */
@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(getFilter());
//        return filterRegistrationBean;
//    }

    @Bean
    public FilterRegistrationBean JWTfilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(getJwtFilter());

        return filterRegistrationBean;
    }

    @Bean
    public JwtAuthenticationFilter getJwtFilter() {
        return new JwtAuthenticationFilter();
    }
//
//
//    @Bean
//    public Filter getFilter() {
//        return new filter();
//    }


}
