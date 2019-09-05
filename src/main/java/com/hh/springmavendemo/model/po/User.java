package com.hh.springmavendemo.model.po;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;

    private String password;

    public User(String name, String password) {
    }
}
