package com.lan.library.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lan.library.api.request.LoginRequest;
import com.lan.library.exception.UserNameEx;
import com.lan.library.utils.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Xiang Lan
 * Created on 2019-07-17 10:50
 */
@Slf4j
public class filter extends GenericFilterBean {


//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("自定义过滤器");
//        ServletRequest requestWrapper = new RequestWrapper(request);
//        ObjectMapper objectMapper = new ObjectMapper();
//        LoginRequest loginRequest = objectMapper.readValue(requestWrapper.getInputStream(), LoginRequest.class);
//        System.err.println(loginRequest);
//
//
//        if (!loginRequest.getUsername().equals("1")) {
//            System.out.println("进入测试");
//            request.setAttribute("error", "nne");
//            request.getRequestDispatcher("/error/uno").forward(request, response);
//            return;
//        }
//
//        filterChain.doFilter(requestWrapper, response);
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("自定义过滤器");
        ServletRequest requestWrapper = new RequestWrapper((HttpServletRequest) request);
        ObjectMapper objectMapper = new ObjectMapper();
        LoginRequest loginRequest = objectMapper.readValue(requestWrapper.getInputStream(), LoginRequest.class);
        log.info(loginRequest.toString());


        if (!loginRequest.getUsername().equals("1")) {
            System.out.println("进入测试");
            request.setAttribute("error", "nne");
            request.getRequestDispatcher("/error/uno").forward(request, response);
            return;
        }

        filterChain.doFilter(requestWrapper, response);
    }
}
