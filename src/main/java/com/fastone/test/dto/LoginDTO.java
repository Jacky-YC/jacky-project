package com.fastone.test.dto;

import com.fastone.test.enuma.MyCheck;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {

    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

}
