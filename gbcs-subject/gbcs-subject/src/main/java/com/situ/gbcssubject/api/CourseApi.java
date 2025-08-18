package com.situ.gbcssubject.api;

import com.situ.gbcssubject.model.Course;
import com.situ.gbcssubject.model.search.CourseSearchBean;
import com.situ.gbcssubject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/v1/courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseApi {
    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public Map<String, Object> findAll(CourseSearchBean csb) {
        List<Course> courseList = this.courseService.findAll(csb);

        //System.out.println(courseList.getFirst().getSubject().getName());

        return Map.of("data", courseList);
    }

}
