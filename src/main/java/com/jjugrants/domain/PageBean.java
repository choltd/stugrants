package com.jjugrants.domain;

import java.util.List;

public class PageBean<T> {
    private int pageSize;//每页条数
    private int totalRecord;//总条数
    private int pageNum;//请求当前页
    private List<T> list;//数据集
    private int totalPage;//总页数
    private int startIndex;//起始坐标

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        if(totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize;
        }else{
            totalPage = totalRecord / pageSize + 1;
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return (pageNum - 1) * pageSize;
    }
}