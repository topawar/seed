package com.seed.winter.dao;

import com.spring.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> selectAll();

    Integer registerUser(User user);

    Integer addUserRecord(String id,String uid);

    String getMaxUserRecordUid();

    Integer UpdateUserInformation(User user);

    User UserLogin(User user);
}
