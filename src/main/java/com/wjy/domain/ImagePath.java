package com.wjy.domain;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 20:32
 * @Description:
 */
public class ImagePath {

    private Integer pathId;
    private Integer goodId;
    private String path;

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ImagePath{" +
                "pathId=" + pathId +
                ", goodId=" + goodId +
                ", path='" + path + '\'' +
                '}';
    }
}
