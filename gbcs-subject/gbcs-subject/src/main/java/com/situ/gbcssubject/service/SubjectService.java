package com.situ.gbcssubject.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.situ.gbcssubject.model.Subject;

import java.util.Collection;

public interface SubjectService {
    Page<Subject> findAll(Page<Subject> page, Subject search);

    Subject findById(Integer id);

    boolean save(Subject subject);

    boolean update(Subject subject);

    int deleteByIds(Collection<Integer> ids);
}
