package com.fastone.test.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fastone.test.domain.User;
import com.fastone.test.service.UserService;
import com.fastone.test.util.Result;
import com.fastone.test.util.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findOne/{uid:\\d+}",method = RequestMethod.GET)
    @JsonView(Result.ResultSimple.class)
    public Result findOne(@PathVariable("uid")  Integer uid){
        User user = userService.findOne(uid).get();
        return new Result(true,"查询成功", StatusCode.OK,  user);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true,"查询成功",StatusCode.OK,userService.findAll());
    }

    @RequestMapping(value = "/delete/{uid:\\d+}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("uid") Integer uid){
        userService.deleteById(uid);
        return new Result(true,"删除成功",StatusCode.OK);
    }

    @JsonView(User.UserDetailView.class)
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Result findOne(@RequestBody User user){
        return new Result(true,"添加成功",StatusCode.OK,userService.addUser(user));
    }

    @RequestMapping(value = "/findByUsername",method = RequestMethod.POST)
    public Result findByUsername(@RequestBody User user){
        System.out.println(user);
        return new Result(true,"查询成功",StatusCode.OK,userService.findByUsername(user.getUsername()));
    }

    @RequestMapping(value = "/countByUsernameLike",method = RequestMethod.POST)
    public Result countByUsernameLike(@RequestBody User user){
        System.out.println(user);
        System.out.println(null==user.getUsername());
        if ("".equals(user.getUsername())){
            log.error("参数为空哦，请重试");
            return new Result(false,"查询失败,参数为空",StatusCode.Fail);
        }
        return new Result(true,"查询成功",StatusCode.OK,userService.countByUsernameLike(user.getUsername()));
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Result testRest(){
        String uri = "http://localhost:8080/findAll";
        return restTemplate.getForObject(URI.create(uri), Result.class);
    }
}
