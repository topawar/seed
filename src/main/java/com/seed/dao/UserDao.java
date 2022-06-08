package com.seed.dao;

import com.seed.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserDao {
    List<User> selectAll();

    Integer registerUser(User user);

    Integer addUserRecord(String id,String uid);

    String getMaxUserRecordUid();

    Integer updateUserInformation(User user);

    User userLogin(User user);

    User userIsExistName(String name);
}
