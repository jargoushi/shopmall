package com.wjy.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 17:57
 * @Description:
 */
public class Goods {

    private Integer goodsId;

    private String goodsName;

    private Integer price;

    private Integer num;

    private Date upTime;

    private Integer category;

    private String detailCate;

    private String description;

    private Integer activityId;

    private MultipartFile fileToUpload;

    private List<ImagePath> imagePaths;

    private Activity activity;

    private boolean fav;

    private Integer newPrice;

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getDetailCate() {
        return detailCate;
    }

    public void setDetailCate(String detailCate) {
        this.detailCate = detailCate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public MultipartFile getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(MultipartFile fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    public List<ImagePath> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<ImagePath> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", upTime=" + upTime +
                ", category=" + category +
                ", detailCate='" + detailCate + '\'' +
                ", description='" + description + '\'' +
                ", activityId=" + activityId +
                ", fileToUpload=" + fileToUpload +
                ", imagePaths=" + imagePaths +
                ", activity=" + activity +
                ", fav=" + fav +
                ", newPrice=" + newPrice +
                '}';
    }
}
