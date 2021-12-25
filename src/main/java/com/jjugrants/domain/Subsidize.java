package com.jjugrants.domain;

public class Subsidize {
    private int subsidizeId;
    private int examineId;

    @Override
    public String toString() {
        return "Subsidize{" +
                "subsidizeId=" + subsidizeId +
                ", examineId=" + examineId +
                '}';
    }

    public int getSubsidizeId() {
        return subsidizeId;
    }

    public void setSubsidizeId(int subsidizeId) {
        this.subsidizeId = subsidizeId;
    }

    public int getExamineId() {
        return examineId;
    }

    public void setExamineId(int examineId) {
        this.examineId = examineId;
    }
}
