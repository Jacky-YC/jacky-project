package com.fastone.test.controller;

import com.fastone.test.util.Result;
import com.fastone.test.util.StatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @GetMapping("/test/resp")
    public ResponseEntity<Result> test(){
        return ResponseEntity.of(Optional.of(new Result(true,"aa",StatusCode.OK,"")));
    }



}
