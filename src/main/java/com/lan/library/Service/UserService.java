package com.lan.library.Service;

import com.lan.library.Entity.Book;
import com.lan.library.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-07-01 10:11
 */
public interface UserService {

    List<User> getUserList();

    User findUserByUserName(String userName,String password);

    User findUserByUserNameAndPassword(String userName,String password);


}
