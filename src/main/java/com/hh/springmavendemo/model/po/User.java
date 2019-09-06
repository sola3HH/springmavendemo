package com.hh.springmavendemo.model.po;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    public User() {} //不加默认构造函数mapper.xml会抛Exception

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}