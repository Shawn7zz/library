package com.lan.library.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lan.library.Dao.BookDao;
import com.lan.library.Dao.UserDao;
import com.lan.library.Entity.Book;
import com.lan.library.Entity.User;
import com.lan.library.Entity.UserBook;
import com.lan.library.JsonObj.Isbn;
import com.lan.library.JsonObj.Items;
import com.lan.library.api.request.BookCriteria;
import com.lan.library.api.response.BookVO;
import com.lan.library.utils.StringUtils;
import com.lan.library.utils.TimeUtils;
import io.swagger.models.auth.In;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author Xiang Lan
 * Created on 2019-07-01 14:10
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    UserDao userDao;

    @Autowired
    BookDao bookDao;


    @Override
    public List<Book> getAllBookList() {
        return bookDao.findAll();
    }

    @Override
    public Boolean addBook(Book book) {
        if (!bookDao.existsByIsbn(book.getIsbn())) {
            bookDao.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Boolean borrowBook(Integer userId, Integer bookId) {
//        User user = userDao.findUserById(userId);
//        Book book = bookDao.findBookById(bookId);
////        user.getBooks().add(book);
//        User user1 = userDao.save(user);

        User user = userDao.findUserById(userId);
        Book book = bookDao.findBookById(bookId);
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        Timestamp borrowTime = new Timestamp(new Date().getTime());
        userBook.setBorrowTime(borrowTime);
        userBook.setReturnTime(TimeUtils.addTime(borrowTime,30));
        user.getBooks().add(userBook);
        userDao.save(user);
        bookDao.save(book);
        return Objects.nonNull(user);
    }

    @Override
    public Boolean returnBook(Integer userId, Integer bookId) {
        User user = userDao.findUserById(userId);
        Book book = bookDao.findBookById(bookId);
        user.getBooks().remove(book);
        User user1 = userDao.save(user);

        return Objects.nonNull(user1);
    }

    @Override
    public BookVO searchBook(BookCriteria bookCriteria) {
        if(bookDao.findBookByIsbn(bookCriteria.getISBN())!=null){

            Book curBook = bookDao.findBookByIsbn(bookCriteria.getISBN());

            return new BookVO(curBook.getIsbn(), curBook.getTitle(), curBook.getAuthor(), curBook.getDescription(), curBook.getPublishedDate(), curBook.getPublisher(), curBook.getCategory());

        }
        String url = "https://www.googleapis.com/books/v1/volumes";
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", "isbn:" + bookCriteria.getISBN()).build();
        RestTemplate restTemplate = new RestTemplate();
        String book = restTemplate.getForObject(uriComponents.toString(), String.class);
        if(book.length()== 47){
            return null;
        }
        Book curBook = null;
        try {
            JsonNode arrNode = new ObjectMapper().readTree(book).findPath("items");
            System.out.println(arrNode.toString());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Items[] items = objectMapper.readValue(arrNode.toString(), Items[].class);
            curBook = items[0].getVolumeInfo();
            curBook.setAuthor(StringUtils.formatStringArray(curBook.getAuthors()));
            curBook.setCategory(StringUtils.formatStringArray(curBook.getCategories()));

            for (Isbn isbn : curBook.getIndustryIdentifiers()) {
                if ("ISBN_13".equals(isbn.getType())) {

                    curBook.setIsbn(isbn.getIdentifier());
                }
            }
            bookDao.save(curBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BookVO(curBook.getIsbn(), curBook.getTitle(), curBook.getAuthor(), curBook.getDescription(), curBook.getPublishedDate(), curBook.getPublisher(), curBook.getCategory());

    }


    @Override
    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public void updateBook(Book preBook, Book curBook) {
        preBook.setIsbn(curBook.getIsbn());
        preBook.setAuthor(curBook.getAuthor());
        preBook.setCategory(curBook.getCategory());
        preBook.setPublisher(curBook.getPublisher());
        preBook.setDescription(curBook.getDescription());
        preBook.setTitle(curBook.getTitle());
        preBook.setPublishedDate(curBook.getPublishedDate());
        bookDao.save(preBook);
    }


}
