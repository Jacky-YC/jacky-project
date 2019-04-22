package com.fastone.test.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private Integer uid;
    private String username;

}
