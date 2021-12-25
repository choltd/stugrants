package com.jjugrants.service;

import com.jjugrants.domain.*;

public interface StuService {
    Student query(Student student);

    PageBean<Student> queryList(PageBean<Student> pageBean) throws Exception;

    boolean applydAdd(Apply apply);

    PageBean<ViewApply> viewApplyPage(PageBean<ViewApply> pageBean, String sequence);

    boolean applyDel(String id);

    ViewApply getApply(String id);

    boolean update(Apply apply);

    PageBean<ViewResult> viewResultPage(PageBean<ViewResult> pageBean);

    boolean pwdUpdate(String id, String password, String change);

    boolean stuDel(String id);
}
