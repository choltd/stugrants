package com.jjugrants.domain;

import java.util.Date;

public class ViewApply {
    private int applyId;
    private String sequence;
    private String name;
    private String sex;
    private String idcard;
    private String telephone;
    private String banknumber;
    private String year;
    private String illustrate;
    private String classname;
    private String major;
    private String college;
    private Date time;
    private String remark;

    @Override
    public String toString() {
        return "ViewApply{" +
                "applyId=" + applyId +
                ", sequence='" + sequence + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", telephone='" + telephone + '\'' +
                ", banknumber='" + banknumber + '\'' +
                ", year='" + year + '\'' +
                ", illustrate='" + illustrate + '\'' +
                ", classname='" + classname + '\'' +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                ", time=" + time +
                ", remark='" + remark + '\'' +
                '}';
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
