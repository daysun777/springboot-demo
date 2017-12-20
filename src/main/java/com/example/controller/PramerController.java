package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class PramerController {

    @RequestMapping(value="get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id) {
       return  "id: " + id;
    }

    @RequestMapping(value="{id}/get", method = RequestMethod.POST)
    public String gettwobyid(@PathVariable("id") Integer id) {
        return  "id: " + id;
    }

    @GetMapping("/list")
    public String list (@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return "page: " + page +" size: "+size;
    }

    @PostMapping("/listTwo")
    public String listTwo (@RequestParam("page") Integer mypage, @RequestParam("size") Integer mysize) {
        return "page: " + mypage +" size: "+mysize;
    }

    @GetMapping("/test")
    // required 必填  defaultValue 默认值
    public String list (@RequestParam(value = "id", required = true) Integer id) {
        return "id: " + id;
    }
}
