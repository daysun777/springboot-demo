package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot!";
    }

    @Value("${cupSize}")
    private  String cupSize;

    @RequestMapping(value="/size", method = RequestMethod.GET)
    public String showCupSize(){
        return cupSize;
    }

    @Value("${age}")
    private Integer age;

    @RequestMapping(value="/showage", method = RequestMethod.GET)
    public Integer showAge(){
        return age;
    }

    @Value("${content}")
    private String content;

    @RequestMapping(value="/content", method = RequestMethod.GET)
    public String content(){
        return content;
    }


}
