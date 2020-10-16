package com.wjy.domain;

import java.util.Date;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/4 15:35
 * @Description:
 */
public class User {

    private Integer userId;

    private String userName;

    private String passWord;

    private Date regTime;

    private String email;

    private String telephone;

    private String confirmPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", regTime=" + regTime +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
