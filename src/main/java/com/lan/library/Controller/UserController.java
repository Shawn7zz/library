package com.lan.library.Controller;

import com.lan.library.Service.BookService;
import com.lan.library.api.request.BookOperationRequest;
import com.lan.library.api.response.UserOperationResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiang Lan
 * Created on 2019-07-08 11:47
 */

@RestController
@RequestMapping("/api")
@Api(value = "user")
public class UserController {

    @Autowired
    BookService bookService;

    @PostMapping("/user/borrow")
    public ResponseEntity<?> borrowBook(@RequestBody BookOperationRequest bookOperationRequest) {

        if (bookService.borrowBook(bookOperationRequest.getUserId(), bookOperationRequest.getBookId())) {
            return new ResponseEntity<>(new UserOperationResponse(true, "You are all set"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new UserOperationResponse(false,"something goes wrong"),HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/user/return")
    public ResponseEntity<?> returnBook(@RequestBody BookOperationRequest bookOperationRequest) {

        if (bookService.returnBook(bookOperationRequest.getUserId(), bookOperationRequest.getBookId())) {
            return new ResponseEntity<>(new UserOperationResponse(true, "You are all set"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new UserOperationResponse(false,"something goes wrong"),HttpStatus.BAD_REQUEST);
    }
}
