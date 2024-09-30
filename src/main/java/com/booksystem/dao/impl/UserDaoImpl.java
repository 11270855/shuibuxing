package com.booksystem.dao.impl;

import com.booksystem.dao.UserDao;
import com.booksystem.model.entity.User;
import com.booksystem.utils.JdbcUtil;
import com.booksystem.utils.UserUtil;
import lombok.Getter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public void addUser(User user) {
        String sql="insert into user(nickname,username,password,gender,avatar,permissions,create_time) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getNickname(),user.getUsername(),user.getPassword(),user.getGender(),user.getAvatar(),10,user.getCreateTime());
    }

    @Override
    public void selectUser() {
        String sql = "Select * From user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,new BeanPropertyRowMapper<User>(User.class));
        System.out.println(list);
        System.out.println(list.get(0).get("username"));
        System.out.println(list.get(0).get("permissions"));
        //System.out.println("----");
    }

    @Override
    public UserUtil queryeUser(User user) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        User foundUser = jdbcTemplate.queryForObject(sql, new Object[]{user.getUsername(), user.getPassword()}, new BeanPropertyRowMapper<>(User.class));
        UserUtil userUtil = new UserUtil();
        System.out.println(foundUser);
        if(foundUser!=null){
            userUtil.setUser(foundUser);
            userUtil.setABoolean(true);
            return userUtil;
        }else return userUtil;
    }
}
