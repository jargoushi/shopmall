package com.wjy.mapper;

import com.wjy.domain.Category;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 21:33
 * @Description:
 */
public interface CategoryMapper {

    List<Category> queryCategory();

    void insert(String catename);

    List<Category> queryCategoryByName(String category);

    Category queryCategoryById(Integer category);
}
