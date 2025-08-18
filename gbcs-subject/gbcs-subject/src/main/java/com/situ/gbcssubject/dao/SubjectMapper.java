package com.situ.gbcssubject.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.situ.gbcssubject.model.Subject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {
    //条件查询
    default Page<Subject> findAll(Page<Subject> page, Subject subject) {
        //查询包装器
        LambdaQueryWrapper<Subject> qw = Wrappers.lambdaQuery(subject);

        return selectPage(page, qw);
    }
}
