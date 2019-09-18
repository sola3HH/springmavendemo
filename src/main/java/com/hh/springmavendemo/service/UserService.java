package com.hh.springmavendemo.service;

import com.hh.springmavendemo.model.po.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    void insertUser(User user);

    List<User> showAllUser();
}