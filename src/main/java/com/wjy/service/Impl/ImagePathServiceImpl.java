package com.wjy.service.Impl;

import com.wjy.domain.ImagePath;
import com.wjy.mapper.ImagePathMapper;
import com.wjy.service.ImagePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 20:32
 * @Description:
 */
@Service
public class ImagePathServiceImpl implements ImagePathService {

    @Autowired
    private ImagePathMapper imagePathMapper;

    public void insert(ImagePath imagePath) {

        imagePathMapper.insert(imagePath);
    }

    public List<ImagePath> queryImagePath(Integer goodsId) {

        return imagePathMapper.queryImagePath(goodsId);
    }
}
