package com.jjugrants.service;

import com.jjugrants.domain.*;

import java.util.List;

public interface TchService {
    Teacher query(Teacher teacher);

    PageBean<Teacher> queryList(PageBean<Teacher> pageBean);

    boolean tchDel(String id);

    PageBean<ViewResult> examinePage(PageBean<ViewResult> vePageBean);

    PageBean<ViewApply> viewApplyPage(PageBean<ViewApply> vaPageBean, String teacherId);

    ViewApply applyShow(String applyId);

    boolean applyFail(Examine examine);

    boolean examine(Examine examine);

    List<ViewResult> searchClassname(String classname);
}
