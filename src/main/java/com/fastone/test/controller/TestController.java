package com.fastone.test.controller;

import com.fastone.test.util.Result;
import com.fastone.test.util.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/test/resp")
    public ResponseEntity<Result> test(){
        return ResponseEntity.of(Optional.of(new Result(true,"aa",StatusCode.OK,"")));
    }

    @GetMapping("/test/{id}")
    public void test(@PathVariable Long id){
        System.out.println(id);
    }

    @PostMapping("/send")
    public void send(@RequestBody String message){
        rabbitTemplate.convertAndSend("sms","user.create","{username:'小明',age:20}");
    }


}
