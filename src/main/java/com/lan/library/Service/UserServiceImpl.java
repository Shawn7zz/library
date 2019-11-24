package com.lan.library.Service;

import com.lan.library.Dao.UserDao;
import com.lan.library.Entity.User;
import com.lan.library.api.request.BookOperationRequest;
import com.lan.library.api.response.UserOperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-07-07 23:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public User findUserByUserName(String userName, String password) {
        return null;
    }

    @Override
    public User findUserByUserNameAndPassword(String userName,String password) {
        return userDao.findUserByNameAndPassword(userName,password);
    }



}
