package com.lan.library.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiang Lan
 * Created on 2019-07-05 13:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequest {

    private String title;

    private String author;

    private String isbn;

    private String description;

    private String categories;

    private String publishedDate;

    private String publisher;
}
