package com.situ.gbcssubject.service.impl;

import com.situ.gbcssubject.dao.CourseMapper;
import com.situ.gbcssubject.model.Course;
import com.situ.gbcssubject.model.search.CourseSearchBean;
import com.situ.gbcssubject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseMapper courseMapper;

    @Autowired
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<Course> findAll(CourseSearchBean csb) {
        return courseMapper.findAll(csb);
    }
}
