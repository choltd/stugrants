package com.jjugrants.domain;

import java.util.Date;

public class ViewResult {
    private int examineId;
    private int subsidizeId;
    private String sequence;
    private String studentName;
    private String studentSex;
    private String studentTelephone;
    private String year;
    private String worknumber;
    private String teacherName;
    private String teacherTelephone;
    private String teacherSex;
    private String state;
    private String college;
    private Date time;

    @Override
    public String toString() {
        return "ViewResult{" +
                "examineId=" + examineId +
                ", subsidizeId=" + subsidizeId +
                ", sequence='" + sequence + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentTelephone='" + studentTelephone + '\'' +
                ", year='" + year + '\'' +
                ", worknumber='" + worknumber + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherTelephone='" + teacherTelephone + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", state='" + state + '\'' +
                ", college='" + college + '\'' +
                ", time=" + time +
                '}';
    }

    public int getExamineId() {
        return examineId;
    }

    public void setExamineId(int examineId) {
        this.examineId = examineId;
    }

    public int getSubsidizeId() {
        return subsidizeId;
    }

    public void setSubsidizeId(int subsidizeId) {
        this.subsidizeId = subsidizeId;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentTelephone() {
        return studentTelephone;
    }

    public void setStudentTelephone(String studentTelephone) {
        this.studentTelephone = studentTelephone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWorknumber() {
        return worknumber;
    }

    public void setWorknumber(String worknumber) {
        this.worknumber = worknumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTelephone() {
        return teacherTelephone;
    }

    public void setTeacherTelephone(String teacherTelephone) {
        this.teacherTelephone = teacherTelephone;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
