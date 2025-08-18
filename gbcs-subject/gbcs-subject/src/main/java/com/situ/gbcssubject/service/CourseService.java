package com.situ.gbcssubject.service;

import com.situ.gbcssubject.model.Course;
import com.situ.gbcssubject.model.search.CourseSearchBean;

import java.util.List;

public interface CourseService {
    List<Course> findAll(CourseSearchBean csb);
}
