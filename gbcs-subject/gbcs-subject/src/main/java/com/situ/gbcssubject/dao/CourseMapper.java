package com.situ.gbcssubject.dao;

import com.situ.gbcssubject.model.Course;
import com.situ.gbcssubject.model.search.CourseSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll(CourseSearchBean csb);
}
