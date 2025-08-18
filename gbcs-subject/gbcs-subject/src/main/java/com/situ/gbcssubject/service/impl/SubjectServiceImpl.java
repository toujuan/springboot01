package com.situ.gbcssubject.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.situ.gbcssubject.dao.SubjectMapper;
import com.situ.gbcssubject.model.Subject;
import com.situ.gbcssubject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@CacheConfig(cacheNames = "s.s.g.s.impl.SubjectServiceImpl")
@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectMapper subjectMapper;

    @Autowired
    public void setSubjectMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public Page<Subject> findAll(Page<Subject> page, Subject search) {
        return subjectMapper.findAll(page, search);
    }

    @Cacheable(key = "'subject-'+#id")
    @Override
    public Subject findById(Integer id) {
        return subjectMapper.selectById(id);
    }

    @CacheEvict(allEntries = true)
    //@CachePut(key = "'subject-'+#a0.id")
    @Override
    public boolean save(Subject subject) {
        return subjectMapper.insert(subject) == 1;
    }

    @CacheEvict(allEntries = true)
    @Override
    public boolean update(Subject subject) {
        return subjectMapper.updateById(subject) == 1;
    }

    @CacheEvict(allEntries = true)
    @Override
    public int deleteByIds(Collection<Integer> ids) {
        //条件判断
        return subjectMapper.deleteByIds(ids);
    }
}
