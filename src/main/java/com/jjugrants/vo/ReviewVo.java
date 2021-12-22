package com.jjugrants.vo;

public class ReviewVo {
    private String sequence;
    private String stuName;
    private String sex;
    private String stuPhone;
    private String workId;
    private String tchName;
    private String tchPhone;
    private String outcome;

    @Override
    public String toString() {
        return "ReviewVo{" +
                "sequence='" + sequence + '\'' +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", workId='" + workId + '\'' +
                ", tchName='" + tchName + '\'' +
                ", tchPhone='" + tchPhone + '\'' +
                ", outcome='" + outcome + '\'' +
                '}';
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getTchPhone() {
        return tchPhone;
    }

    public void setTchPhone(String tchPhone) {
        this.tchPhone = tchPhone;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
