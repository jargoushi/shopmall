package com.wjy.service;

import com.wjy.domain.Comment;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/9 18:11
 * @Description:
 */
public interface CommentService {


    List<Comment> queryCommentByGoodsId(Integer goodsId);

    boolean insertComment(Comment comment);
}
