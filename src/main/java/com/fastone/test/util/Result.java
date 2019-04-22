package com.fastone.test.util;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Result {

    boolean code;
    String message;
    Integer statusCode;
    Object object;

    public Result(boolean code, String message, Integer statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

}
