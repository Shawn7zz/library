package com.lan.library.Entity;

import com.lan.library.Dao.BookDao;
import com.lan.library.Dao.UserDao;
import com.lan.library.Service.BookServiceImpl;
import com.lan.library.Service.UserService;
import com.lan.library.api.request.BookCriteria;
import com.lan.library.utils.TimeUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author Xiang Lan
 * Created on 2019-06-26 17:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {


    @Autowired
    BookDao bookDao;

    @Autowired
    UserDao userDao;

    @Autowired
    BookServiceImpl bookService;

    @org.junit.Test
    public void test2() {
//        User user = userDao.findUserById(10);
//        Book book = bookDao.findBookById(43);
//        UserBook userBook = new UserBook();
//        userBook.setUser(user);
//        userBook.setBook(book);
//        Timestamp borrowTime = new Timestamp(new Date().getTime());
//        userBook.setBorrowTime(borrowTime);
//        userBook.setReturnTime(TimeUtils.addTime(borrowTime,30));
//        user.getBooks().add(userBook);
//        userDao.save(user);
//        bookDao.save(book);
    }
}
