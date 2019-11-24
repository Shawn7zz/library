package com.lan.library.Dao;

import com.lan.library.Entity.Book;
import com.lan.library.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-06-25 22:57
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {


    User findUserByName(String userName);

    User findUserByEmail(String email);

    User findUserById(Integer id);

    Boolean existsByNameAndAndPassword(String userName, String password);

    User findUserByNameAndPassword(String userName, String password);

}
