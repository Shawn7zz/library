package com.lan.library.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiang Lan
 * Created on 2019-07-08 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookOperationResponse {

    private Boolean success;

    private String message;



}
