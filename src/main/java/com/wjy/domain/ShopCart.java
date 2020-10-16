package com.wjy.domain;

import java.util.Date;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/11 21:20
 * @Description:
 */
public class ShopCart {

    private Integer userId;

    private Integer goodsId;

    private Date cateDate;

    private Integer goodsNum;

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

    public Date getCateDate() {
        return cateDate;
    }

    public void setCateDate(Date cateDate) {
        this.cateDate = cateDate;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "userId=" + userId +
                ", goodsId=" + goodsId +
                ", cateDate=" + cateDate +
                ", goodsNum=" + goodsNum +
                '}';
    }
}
