package com.wjy.service;

import com.wjy.domain.Category;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 21:31
 * @Description:
 */
public interface CategoryService {

    List<Category> queryCategory();

    void insert(String cateName);

    Category queryCategoryById(Integer category);
}
