package com.example.util;

import com.example.model.User;

import java.util.List;

public class UserDao extends BaseDao {
    // 查询全部
    public List<User> getAll(){
        String sql="select * from user";
        List<User> list=super.query(sql, null, User.class);
        return list;
    }

    public List<User> findById(int id){
        String sql = "select * from user where id=?";
        List<User> list=super.query(sql, new Integer[]{id}, User.class);
        return list;
    }

    public int addUser (User user) {
        String sql = "insert into user (name, age) values(?, ?)";
        Object[] param = {user.getName(), user.getAge()};
        return super.update(sql, param);
    }
}
