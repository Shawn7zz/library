package com.lan.library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lan.library.JsonObj.Isbn;
import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Xiang Lan
 * Created on 2019-06-25 21:58
 */
@Entity(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Transient
    private String[] authors;

    @Column(name = "description")
    private String description;

    @Column(name = "publish_date")
    private String publishedDate;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "categories")
    private String category;

    @Transient
    private Isbn[] industryIdentifiers;

    @Transient
    private String[] categories;

//    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Set<UserBook> users = new HashSet<>();

//    @Override
//    public String toString() {
//        return "Book{" +
//                "title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", description='" + description + '\'' +
//                ", publishedDate='" + publishedDate + '\'' +
//                ", publisher='" + publisher + '\'' +
//                ", category='" + category + '\'' +
//                ", isbn='" + isbn + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", description='" + description + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", industryIdentifiers=" + Arrays.toString(industryIdentifiers) +
                ", categories=" + Arrays.toString(categories) +
                ", users=" + users +
                '}';
    }
}
