package com.lan.library.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiang Lan
 * Created on 2019-07-01 15:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCriteria {

    private String ISBN;

    private String title;

    private String type;
}
