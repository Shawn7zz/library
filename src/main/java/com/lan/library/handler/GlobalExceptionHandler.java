package com.lan.library.handler;

import com.lan.library.api.response.UserOperationResponse;
import com.lan.library.exception.UserNameEx;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Xiang Lan
 * Created on 2019-07-16 16:43
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 全局异常拦截，封装报错信息
     *
     * @param exception
     * @return
     */

    @ExceptionHandler(UsernameNotFoundException.class)
    public UserOperationResponse UsernameNotFoundExceptionHandler(Exception exception) {

        log.info(exception.getMessage());

       return new UserOperationResponse(false,"This user is not exist");
    }

    @ExceptionHandler(BadCredentialsException.class)
    public UserOperationResponse BadCrExceptionHandler(Exception exception){

        log.info(exception.getMessage());


        return new UserOperationResponse(false,"password is wrong");
    }

    @ExceptionHandler(UserNameEx.class)
    public UserOperationResponse Uex (UserNameEx exception){

        log.info(exception.getMessage());

        return new UserOperationResponse(false,"过滤器异常测试");
    }




}

