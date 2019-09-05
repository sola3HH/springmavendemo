package com.hh.springmavendemo.dao;

import com.hh.springmavendemo.model.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByUserId(int id);

    List<User> selectAll();
}
