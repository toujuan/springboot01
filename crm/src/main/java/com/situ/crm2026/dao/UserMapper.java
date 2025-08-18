package com.situ.crm2026.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.situ.crm2026.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    default User findByPhone(String phone) {
        LambdaQueryWrapper<User> qw = Wrappers.lambdaQuery();
        qw.eq(User::getPhone, phone);
        return selectOne(qw);
    }
}
