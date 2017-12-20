package com.example.controller;

import com.example.core.Result;
import com.example.core.ResultGenerator;
import com.example.model.User;
import com.example.util.UserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserJdbcController {
    /**
     * 原生JDBC操作
     */
    private UserDao userDao = new UserDao();

    @GetMapping("/getAllUser")
    public Result findAllUser () {
        List<User> list = userDao.getAll();
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("getUserById")
    public Result getUserById(@RequestParam("id") Integer id){
        List<User> list = userDao.findById(id);
        return ResultGenerator.genSuccessResult(list);
    }

    @GetMapping("/jdbcAddUser")
    public Result addUser (@RequestParam("name") String name, @RequestParam("age") int age) {
        User user = new User(name, age);
        int rt = userDao.addUser(user);
        return ResultGenerator.genSuccessResult(rt);
    }
}
