package com.jjugrants.vo;

public class StudentVo {
    private int studentId;
    private String name;
    private String sequence;
    private String password;
    private String sex;
    private String idcard;
    private String telephone;
    private String banknumber;
    private String year;
    private int teacherId;
    private String classname;
    private String major;
    private String college;

    @Override
    public String toString() {
        return "StudentVo{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", sequence='" + sequence + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", telephone='" + telephone + '\'' +
                ", banknumber='" + banknumber + '\'' +
                ", year='" + year + '\'' +
                ", teacherId=" + teacherId +
                ", classname='" + classname + '\'' +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
