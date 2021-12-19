package com.jjugrants.vo;

import java.util.Date;

public class FiledVo {
    private String sequence;
    private String name;
    private int sex;
    private String idcard;
    private String phone;
    private String bankcard;
    private int id;
    private int studentId;
    private String illustrate;
    private Date time;
    private String rating;
    private String remark;

    @Override
    public String toString() {
        return "FiledVo{" +
                "sequence='" + sequence + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", bankcard='" + bankcard + '\'' +
                ", id=" + id +
                ", studentId=" + studentId +
                ", illustrate='" + illustrate + '\'' +
                ", time=" + time +
                ", rating='" + rating + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
