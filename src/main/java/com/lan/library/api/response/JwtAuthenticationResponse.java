package com.lan.library.api.response;

import lombok.Data;

/**
 * @author Xiang Lan
 * Created on 2019-07-18 17:07
 */
@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
