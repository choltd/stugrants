package com.jjugrants.domain;

public class Tips {
    private int tipsId;
    private String content;
    private int examineId;

    @Override
    public String toString() {
        return "Tips{" +
                "tipsId=" + tipsId +
                ", content='" + content + '\'' +
                ", examineId=" + examineId +
                '}';
    }

    public int getTipsId() {
        return tipsId;
    }

    public void setTipsId(int tipsId) {
        this.tipsId = tipsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getExamineId() {
        return examineId;
    }

    public void setExamineId(int examineId) {
        this.examineId = examineId;
    }
}
