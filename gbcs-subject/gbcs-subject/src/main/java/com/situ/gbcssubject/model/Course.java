package com.situ.gbcssubject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonIgnoreProperties("handler")
@Getter
@Setter
public class Course {
    private Integer id;
    private String name;
    private LocalDateTime beginTime;
    private Integer duration;
    private Integer memberLimit;
    private String room;

    private Subject subject;
}
