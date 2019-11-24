package com.lan.library.JsonObj;

import com.lan.library.Entity.Book;
import com.lan.library.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-07-02 14:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Items {

    private Book volumeInfo;

}
