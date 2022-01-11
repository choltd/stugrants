package com.jjugrants.domain;

public class Stuclass {
    private int stuclassId;
    private int teacherId;
    private String classname;
    private String major;
    private String college;

    @Override
    public String toString() {
        return "Stuclass{" +
                "stuclassId=" + stuclassId +
                ", teacherId=" + teacherId +
                ", classname='" + classname + '\'' +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    public int getStuclassId() {
        return stuclassId;
    }

    public void setStuclassId(int stuclassId) {
        this.stuclassId = stuclassId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
}
