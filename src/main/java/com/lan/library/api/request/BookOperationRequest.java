package com.lan.library.api.request;

import lombok.*;

/**
 * @author Xiang Lan
 * Created on 2019-06-26 15:19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookOperationRequest {

    private Integer userId;

    private Integer bookId;
}
