package com.hh.springmavendemo.dao;

import com.hh.springmavendemo.model.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByUserId(int id);

    List<User> selectAll();
}
