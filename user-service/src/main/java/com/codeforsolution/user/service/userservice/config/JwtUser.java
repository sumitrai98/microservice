/**
 * @Author codeforsolution
 *
 **/
package com.codeforsolution.user.service.userservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data @AllArgsConstructor
public class JwtUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String username;
    private final String roles; //roles could be a comma separated list



}
