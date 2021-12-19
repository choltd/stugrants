package com.jjugrants.vo;

public class GrantsVo {
    private int id;
    private String sequence;
    private String workId;
    private int adminId;
    private int filedId;
    private String phone;
    private String illustrate;

    @Override
    public String toString() {
        return "GrantsVo{" +
                "id=" + id +
                ", sequence=" + sequence +
                ", workId=" + workId +
                ", adminId=" + adminId +
                ", filedId=" + filedId +
                ", phone='" + phone + '\'' +
                ", illustrate='" + illustrate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getFiledId() {
        return filedId;
    }

    public void setFiledId(int filedId) {
        this.filedId = filedId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate;
    }
}
