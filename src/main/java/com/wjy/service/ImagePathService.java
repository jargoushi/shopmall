package com.wjy.service;

import com.wjy.domain.ImagePath;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 20:32
 * @Description:
 */
public interface ImagePathService {


    void insert(ImagePath imagePath);

    List<ImagePath> queryImagePath(Integer goodsId);
}
