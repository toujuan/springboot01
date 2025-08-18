package com.situ.gbcssubject.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.situ.gbcssubject.model.Subject;
import com.situ.gbcssubject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubjectApi {
    private SubjectService subjectService;

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public Map<String, Object> findAll(Subject subject, Integer pageNo, Integer pageSize) {
        //分页之后的数据
        Page<Subject> page = new Page<>(pageNo, pageSize);
        page = this.subjectService.findAll(page, subject);
        return Map.of("data", page);
    }

    @GetMapping("/id")
    public Map<String, Object> findById(Integer id) {
        Subject subject = this.subjectService.findById(id);
        return Map.of("data", subject);
    }

    @PostMapping
    public Map<String, Object> save(@RequestBody Subject subject) {
        boolean success = this.subjectService.save(subject);
        System.out.println(subject.getId());
        return Map.of("success", success);
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Subject subject) {
        boolean success = this.subjectService.update(subject);
        System.out.println(subject.getId());
        return Map.of("success", success);
    }

    @DeleteMapping
    public Map<String, Object> deleteByIds(@RequestBody Integer[] ids) {
        int count = this.subjectService.deleteByIds(List.of(ids));
        return Map.of("count", count);
    }
}
