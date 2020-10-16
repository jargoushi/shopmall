package com.wjy.domain;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:40
 * @Description:
 */
public class OrderItem {

    private Integer itemId;
    private Integer orderId;
    private Integer goodsId;

    private Integer num;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", num=" + num +
                '}';
    }
}
