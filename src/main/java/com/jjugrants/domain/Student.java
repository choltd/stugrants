package com.jjugrants.domain;

public class Student {
    private int studentId;
    private int stuclassId;
    private String name;
    private String sequence;
    private String password;
    private String sex;
    private String idcard;
    private String telephone;
    private String banknumber;
    private String year;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", stuclassId=" + stuclassId +
                ", name='" + name + '\'' +
                ", sequence='" + sequence + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", telephone='" + telephone + '\'' +
                ", banknumber='" + banknumber + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStuclassId() {
        return stuclassId;
    }

    public void setStuclassId(int stuclassId) {
        this.stuclassId = stuclassId;
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
}
