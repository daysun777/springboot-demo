package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class TmpController {

    @GetMapping("")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView showTmp(){
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @Value("${age}")
    private Integer age;

    @RequestMapping(value="/getAge", method = RequestMethod.GET)
    public Integer showAge(){
        return age;
    }

}
