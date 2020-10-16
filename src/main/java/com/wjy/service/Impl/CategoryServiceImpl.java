package com.wjy.service.Impl;

import com.wjy.domain.Category;
import com.wjy.mapper.CategoryMapper;
import com.wjy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 21:31
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategory() {
        return categoryMapper.queryCategory();
    }

    public void insert(String cateName) {

        categoryMapper.insert(cateName);
    }

    public Category queryCategoryById(Integer category) {
        return categoryMapper.queryCategoryById(category);
    }
}
