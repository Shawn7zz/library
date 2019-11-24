package com.lan.library.Controller;

import com.lan.library.exception.UserNameEx;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Xiang Lan
 * Created on 2019-07-17 15:02
 */
@RestController
@RequestMapping("/error")
public class ErrorsController {


    @PostMapping("/uno")
    public void throwError(HttpServletRequest request) {
        System.out.println(request.getAttribute("error"));
        throw new UserNameEx("用户不存在");
    }
}
