package com.jjugrants.dao;

import com.jjugrants.domain.*;
import com.jjugrants.vo.StudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StuDao {
    StudentVo query(Student student);//支持模糊查询学号和名字

    Map<String, Object> count();

    Map<String, Object> applyCount();

    List<Student> stuPage(PageBean<Student> pageBean);//按页查询数据

    int applyAdd(Apply apply);

    List<ViewApply> viewApplyPage(@Param("va") PageBean<ViewApply> pageBean, @Param("sq") String sequence);

    int applyDel(String id);

    ViewApply getApply(String id);

    int update(Apply apply);

    Map<String, Object> subsidizeCount();

    List<ViewResult> viewResultPage(PageBean<ViewResult> pageBean);

    int verify(@Param("id") String id, @Param("pwd") String change);

    int pwdUpdate(@Param("id") String id, @Param("chg") String change);

    int stuDel(String id);

    Map<String, Object> vaCount(String sequence);

    Map<String, Object> applyCountTeacherId(String teacherId);
}
