package com.jjugrants.domain;

import java.util.Date;

public class Apply {
    private int applyId;
    private int studentId;
    private String illustrate;
    private Date time;
    private String remark;

    @Override
    public String toString() {
        return "Apply{" +
                "applyId=" + applyId +
                ", studentId=" + studentId +
                ", illustrate='" + illustrate + '\'' +
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
