package com.fastone.test.controller;

import com.fastone.test.dto.LoginDTO;
import com.fastone.test.service.UserService;
import com.fastone.test.util.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Result> login(@Valid @RequestBody LoginDTO loginInfo){
        System.out.println(loginInfo);
        return new ResponseEntity<Result>(HttpStatus.OK);
    }


}
