package com.lan.library.api.response;

import com.lan.library.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiang Lan
 * Created on 2019-07-01 14:40
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOperationResponse {


    private Boolean success;

    private String message;

}
