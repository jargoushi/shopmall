package com.wjy.domain;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/5 15:06
 * @Description:
 */
public class Activity {

    private Integer activityId;

    private String activityName;

    private String activityDes;

    private Float discount;

    private Integer fullPrice;

    private Integer reducePrice;

    private Integer fullNum;

    private Integer reduceNum;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDes() {
        return activityDes;
    }

    public void setActivityDes(String activityDes) {
        this.activityDes = activityDes;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Integer fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Integer getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(Integer reducePrice) {
        this.reducePrice = reducePrice;
    }

    public Integer getFullNum() {
        return fullNum;
    }

    public void setFullNum(Integer fullNum) {
        this.fullNum = fullNum;
    }

    public Integer getReduceNum() {
        return reduceNum;
    }

    public void setReduceNum(Integer reduceNum) {
        this.reduceNum = reduceNum;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityDes='" + activityDes + '\'' +
                ", discount=" + discount +
                ", fullPrice=" + fullPrice +
                ", reducePrice=" + reducePrice +
                ", fullNum=" + fullNum +
                ", reduceNum=" + reduceNum +
                '}';
    }
}
