package com.jjugrants.domain;

import java.util.Date;

public class Examine {
    private int examineId;
    private int teacherId;
    private int applyId ;
    private String state;
    private Date time;

    @Override
    public String toString() {
        return "Examine{" +
                "examineId=" + examineId +
                ", teacherId=" + teacherId +
                ", applyId=" + applyId +
                ", state='" + state + '\'' +
                ", time=" + time +
                '}';
    }

    public int getExamineId() {
        return examineId;
    }

    public void setExamineId(int examineId) {
        this.examineId = examineId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
