package com.hh.springmavendemo.service.impl;

import com.hh.springmavendemo.dao.UserMapper;
import com.hh.springmavendemo.model.po.User;
import com.hh.springmavendemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteUserById(Integer id){
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> showAllUser() {
        return userMapper.selectAll();
    }

}
