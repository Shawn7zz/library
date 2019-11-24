package com.lan.library.api.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiang Lan
 * Created on 2019-07-08 19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {

    private String isbn;

    private String title;

    private String author;

    private String description;

    private String publishedDate;

    private String publisher;

    private String category;
}
