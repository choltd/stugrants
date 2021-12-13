package com.jjugrants.domain;

import java.util.Date;

public class Filed {
    private int id;
    private int studentId;
    private String illustrate;
    private Date time;
    private String rating;
    private String remark;

    @Override
    public String toString() {
        return "Filed{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", illustrate='" + illustrate + '\'' +
                ", time=" + time +
                ", rating='" + rating + '\'' +
                ", remark='" + remark + '\'' +
                '}';
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
