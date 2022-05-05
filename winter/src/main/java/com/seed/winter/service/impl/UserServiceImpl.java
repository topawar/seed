package com.seed.winter.service.impl;

import com.seed.utils.DateUtils;
import com.seed.winter.dao.UserDao;
import com.seed.winter.service.UserService;
import com.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> selectAll() {
        List<User> users = userDao.selectAll();
        System.out.println(users);
        return users;
    }

    @Override
    public Integer registerUser(User user) {
        Date date = new Date();
        String pattern = "YYYY-MM-dd HH:mm:ss";
        String registerDate = DateUtils.PatternFormatDate(date, pattern);
        user.setId(UUID.randomUUID().toString());
        user.setUid(getMaxUserRecordUid());
        user.setCreateTime(registerDate);
        user.setUpdateTime(registerDate);
        Integer result = userDao.registerUser(user);
        userDao.addUserRecord(user.getId(),user.getUid());
        return result;
    }

    @Override
    public Integer addUserRecord(String id, String uid) {
        return userDao.addUserRecord(id,uid);
    }

    @Override
    public String getMaxUserRecordUid() {
        String maxCellUid = userDao.getMaxUserRecordUid();
        if ("".equals(maxCellUid) || maxCellUid.isEmpty()){
            System.out.println(maxCellUid);
            return "10000"; //默认uid从10000开始
        }
        return String.valueOf((Integer.parseInt(maxCellUid)+1));
    }

    @Override
    public Integer UpdateUserInformation(User user) {
        return userDao.UpdateUserInformation(user);
    }

    @Override
    public User UserLogin(User user) {
        return userDao.UserLogin(user);
    }
}