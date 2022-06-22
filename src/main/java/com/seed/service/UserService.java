package com.seed.service;

import com.seed.entity.User;


import java.util.List;

public interface UserService {

    List<User> selectAll();

    Integer registerUser(User user);

    Integer addUserRecord(String id,String uid);

    String getMaxUserRecordUid();

    Integer updateUserInformation(User user);

    User userLogin(User user);

    User userGetById(String uid);
}
