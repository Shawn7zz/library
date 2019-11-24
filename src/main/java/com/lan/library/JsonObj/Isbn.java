package com.lan.library.JsonObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiang Lan
 * Created on 2019-07-05 10:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Isbn {

    private String type;
    private String identifier;

}
