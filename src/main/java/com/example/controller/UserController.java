package com.example.controller;

import com.example.core.Result;
import com.example.core.ResultGenerator;

import org.springframework.web.bind.annotation.*;

import com.example.mapper.UserMapper;
import com.example.model.User;

import javax.annotation.Resource;
import java.util.List;

@RestController // 标记为：restful
// @RequestMapping("/demo") 接口前缀
public class UserController {

    @Resource
    UserMapper userMapper;

    /**
     * 根据results
     *
     * @return
     */
    @RequestMapping(value="/find", method = RequestMethod.GET)
    public String getAll() {
        List<User> list = userMapper.findAll();
        return list.toString();
    }

    /**
     * 直接返回的是json
     * Spring boot默认使用的json解析框加是jackjosn
     *
     */
    @GetMapping("/findById")
    public User findById(@RequestParam("id") Integer id) {
        User user = userMapper.findById(id);
        return user;
    }


    @GetMapping("/findByGetId")
    public Result findByGetId(@RequestParam("id") Integer id) {
        User user = userMapper.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @GetMapping("/findall")
    public Result findAll () {
        List<User> list = userMapper.findAll();
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/addUser")
    public Result addUser (@RequestParam("name") String name, @RequestParam("age") int age) {
        User user = new User(name, age);
        int rt = userMapper.addUser2(user);
        return ResultGenerator.genSuccessResult(rt);
    }


    @GetMapping("/updateUserCtrol")
    public Result updateUser (@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("id") int id) {
        int rt = userMapper.updateUser(name, age, id);
        return ResultGenerator.genSuccessResult(rt);
    }


    @GetMapping("/del/{id}")
    public Result delUser (@PathVariable int id) {
        return ResultGenerator.genSuccessResult(userMapper.del(id));
    }
}
