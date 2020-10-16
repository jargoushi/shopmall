package com.wjy.mapper;

import com.wjy.domain.ImagePath;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 20:35
 * @Description:
 */
public interface ImagePathMapper {

    void insert(ImagePath imagePath);

    List<ImagePath> queryImagePath(Integer goodsId);

}
