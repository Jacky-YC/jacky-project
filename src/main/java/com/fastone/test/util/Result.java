package com.fastone.test.util;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Result {

    public interface ResultSimple{};
    public interface ResultDetail extends ResultSimple{};

    @JsonView(ResultSimple.class)
    boolean code;

    @JsonView(ResultSimple.class)
    String message;

    @JsonView(ResultSimple.class)
    Integer statusCode;

    @JsonView(ResultSimple.class)
    Object object;

    public Result(boolean code, String message, Integer statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

}
