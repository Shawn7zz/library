package com.lan.library.Service;

import com.lan.library.Entity.Book;
import com.lan.library.Entity.User;
import com.lan.library.api.request.BookCriteria;
import com.lan.library.api.response.BookVO;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-07-01 10:09
 */
public interface BookService {

    List<Book> getAllBookList();

    Boolean addBook(Book book);

    Boolean borrowBook(Integer userId, Integer bookId);

    Boolean returnBook(Integer userId, Integer bookId);

    BookVO searchBook(BookCriteria bookCriteria);

    Book findBookById(Integer id);

    void deleteBookById(Integer id);

    void updateBook(Book preBook, Book curBook);
}
