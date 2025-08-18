package com.situ.crm2026.service.impl;

import com.situ.crm2026.dao.UserMapper;
import com.situ.crm2026.model.User;
import com.situ.crm2026.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }
}
