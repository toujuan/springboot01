package com.situ.gbcssubject.model;

import java.util.List;

public class Category {
    private Integer id;
    private String name;

    private Integer parentId;//父分类


    private List<Category> children;
}
