package com.lan.library.Controller;

import com.lan.library.Dao.BookDao;
import com.lan.library.Entity.Book;
import com.lan.library.Service.BookService;
import com.lan.library.Service.BookServiceImpl;
import com.lan.library.api.request.BookCriteria;
import com.lan.library.api.request.BookOperationRequest;
import com.lan.library.api.response.BookOperationResponse;
import com.lan.library.api.response.BookVO;
import com.lan.library.api.response.UserOperationResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Xiang Lan
 * Created on 2019-06-26 09:50
 */

@RestController
@RequestMapping("/api")
@Api(value = "book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/book/isbn")
    public ResponseEntity<?> searchBook(@RequestParam(name = "isbn") String isbn){
        BookCriteria bookCriteria = new BookCriteria();
        bookCriteria.setISBN(isbn);
        BookVO bookVO = bookService.searchBook(bookCriteria);
        if (bookVO == null || bookVO.getTitle() == null){
            return new ResponseEntity<>("No such Book",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bookVO,HttpStatus.OK);
    }


    @PostMapping("/book")
    public ResponseEntity<BookOperationResponse> addBook(@RequestBody Book book) {
        if (bookService.addBook(book)) {
            return new ResponseEntity<>(new BookOperationResponse(true,"Book is successfully add"), HttpStatus.OK);

        }
        return new ResponseEntity<>(new BookOperationResponse(false,"Book is exist, add fail"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> listBook() {

        return new ResponseEntity<>(bookService.getAllBookList(), HttpStatus.OK);

    }

    @PutMapping("/book/{id}")
    public ResponseEntity<BookOperationResponse> updateBook(@PathVariable("id") Integer id, @RequestBody Book curBook) {
        Book preBook = bookService.findBookById(id);
        if (Objects.nonNull(preBook)) {
            bookService.updateBook(preBook,curBook);
            return new ResponseEntity<>(new BookOperationResponse(true,"update successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BookOperationResponse(false,"Update failed"),HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<BookOperationResponse> deleteBook(@PathVariable("id") Integer id) {
        Book book = bookService.findBookById(id);
        if (Objects.isNull(book)) {
            return new ResponseEntity<>(new BookOperationResponse(false,"Book is not exist"), HttpStatus.BAD_REQUEST);
        }

        bookService.deleteBookById(id);

        return new ResponseEntity<>(new BookOperationResponse(true,"Book is deleted"), HttpStatus.OK);
    }

}
