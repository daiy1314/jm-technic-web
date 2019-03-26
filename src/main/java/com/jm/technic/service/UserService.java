package com.jm.technic.service;

import com.jm.technic.domain.User;

import java.util.List;

public interface UserService {
    User findByName(String userName);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
