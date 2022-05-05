package com.seed.winter.service;

import com.spring.entity.User;


import java.util.List;

public interface UserService {
    List<User> selectAll();

    Integer registerUser(User user);

    Integer addUserRecord(String id,String uid);

    String getMaxUserRecordUid();

    Integer UpdateUserInformation(User user);

    User UserLogin(User user);
}
