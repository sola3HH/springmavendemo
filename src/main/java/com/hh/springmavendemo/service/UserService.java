package com.hh.springmavendemo.service;

import com.hh.springmavendemo.model.po.User;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    @Async
    void insertUser(User user);

    List<User> showAllUser();
}