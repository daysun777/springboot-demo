package com.example.controller;

import com.example.model.Group;
import com.example.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FastjosnController {

    private Group group = new Group();
    @GetMapping("/json1")
    public String jsonOne () {

        group.setId(32);
        group.setAge(32);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(33);
        guestUser.setAge(33);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(34);
        guestUser.setAge(34);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group);

        System.out.println(jsonString);
        return jsonString;
    }

    @GetMapping("/json2")
    public List jsonTwo() {
        List<User> list = new ArrayList<User>();
        User user1 = new User();
        user1.setId(33);
        user1.setAge(33);
        user1.setName("guest111");

        User user2 = new User();
        user2.setId(34);
        user2.setAge(34);
        user2.setName("root222");

        list.add(user1);
        list.add(user2);
        return list;
    }

    @GetMapping("/json3")
    public String jsonThree() {
        List<Object> list  = new ArrayList<Object>();
        User user1 = new User();
        user1.setId(33);
        user1.setAge(33);
        user1.setName("guest111");

        User user2 = new User();
        user2.setId(34);
        user2.setAge(34);
        user2.setName("root222");

        list.add(user1);
        list.add(user2);

        //List集合中的元素可以重复
        Map<String, String> map = new HashMap<String, String>();
        map.put("java", "java srping");
        map.put("php", "php php");
        map.put(".net", "c#");


        //System.out.println(list);
        list.add(map);
        String jsonString = JSON.toJSONString(list);
        //jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    @GetMapping("/json4")
    public List jsonFour() {
        List<Object> list  = new ArrayList<Object>();
        list.add("java");
        list.add("php");//List集合中的元素可以重复
        list.add(".net");
        System.out.println("原集合："+list);
        return list;
    }
    
    @GetMapping("/json9")
    public String jsonCustomkey () {
        User user1 = new User();
        user1.setId(33);
        user1.setAge(33);
        user1.setName("guest111");

        List<User> userInfo=new ArrayList<>();
        List<User> user=new ArrayList<>();
        JSONObject a=new JSONObject();

        user.add(user1);
        a.put("user",user);
        a.put("userInfo",userInfo);
        a.put("name", user1.getName());
        return a.toString();
    }
}
