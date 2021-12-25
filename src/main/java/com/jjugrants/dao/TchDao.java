package com.jjugrants.dao;

import com.jjugrants.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TchDao {
    Teacher query(Teacher teacher);

    Map<String, Object> count();

    Map<String, Object> examineCount();

    List<Teacher> tchPage(PageBean<Teacher> pageBean);

    int tchDel(String id);

    List<ViewResult> examinePage(PageBean<ViewResult> vePageBean);

    List<ViewApply> viewApplyPage(@Param("va") PageBean<ViewApply> vaPageBean, @Param("teacherId") String teacherId);

    ViewApply applyShow(String applyId);

    int applyFail(Examine examine);

    int examine(Examine examine);

    List<ViewResult> searchClassname(String classname);
}
