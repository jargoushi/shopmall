package com.wjy.mapper;

import com.wjy.domain.Comment;

import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/9 18:12
 * @Description:
 */
public interface CommentMapper {


    List<Comment> queryCommentByGoodsId(Integer goodsId);

    int insertComment(Comment comment);
}
