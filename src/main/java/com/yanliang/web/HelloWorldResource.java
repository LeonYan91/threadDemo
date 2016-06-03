package com.yanliang.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanliang
 * @ClassName HelloWorldResource
 * @Description
 * @Date 2016/5/19
 */

@RestController
public class HelloWorldResource {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "Greeting from Spring Boot";
    }
}
