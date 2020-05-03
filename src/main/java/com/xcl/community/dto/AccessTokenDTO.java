package com.xcl.community.dto;

import lombok.Data;

/**
 * AccessTokenDTO
 *
 * @author 徐长乐
 * @date 2020/5/1
 */
@Data
public class AccessTokenDTO {

    private String client_id;

    private String client_secret;

    private String code;

    private String redirect_uri;

    private String state;

}
