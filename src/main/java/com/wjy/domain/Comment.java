package com.wjy.domain;

import java.util.Date;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/9 17:51
 * @Description:
 */
public class Comment {

    private Integer commentId;

    private Integer userId;

    private Integer goodsId;

    private Integer point;

    private String content;

    private Date commentTime;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", point=" + point +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
