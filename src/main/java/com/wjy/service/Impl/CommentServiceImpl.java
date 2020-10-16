package com.wjy.service.Impl;

import com.wjy.domain.Comment;
import com.wjy.mapper.CommentMapper;
import com.wjy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/9 18:12
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    public List<Comment> queryCommentByGoodsId(Integer goodsId) {
        return commentMapper.queryCommentByGoodsId(goodsId);
    }

    public boolean insertComment(Comment comment) {
        return commentMapper.insertComment(comment) > 0;
    }
}
