package com.lan.library.api.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @author Xiang Lan
 * Created on 2019-06-25 23:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;


}
