package com.lan.library.Dao;

import com.lan.library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-06-25 22:57
 */
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findAllByAuthor(String author);

    Book findBookByTitle(String title);

    Book findBookById(Integer id);

    Book findBookByIsbn(String isbn);

    Boolean existsByIsbn(String isbn);


}
