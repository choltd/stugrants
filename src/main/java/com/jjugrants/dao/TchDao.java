package com.jjugrants.dao;

import com.jjugrants.domain.*;
import com.jjugrants.vo.TeacherVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TchDao {
    TeacherVo query(Teacher teacher);

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

    Map<String, Object> viewResultCount();

    int verify(@Param("teacherId") String teacherId, @Param("pwd") String password);

    int pwdUpdate(@Param("teacherId") String teacherId, @Param("chg") String change);

    int tchAdd(Teacher teacher);
}
