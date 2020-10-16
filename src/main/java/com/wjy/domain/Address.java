package com.wjy.domain;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/6 21:24
 * @Description:
 */
public class Address {

    private Integer addressID;
    private Integer userId;
    private String province;
    private String city;
    private String county;
    private String detailAddr;
    private String conName;
    private String conTel;

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID=" + addressID +
                ", userId=" + userId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", detailAddr='" + detailAddr + '\'' +
                ", conName='" + conName + '\'' +
                ", conTel='" + conTel + '\'' +
                '}';
    }
}
