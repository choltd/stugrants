package com.jjugrants.dao;

import com.jjugrants.domain.Filed;
import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Student;
import com.jjugrants.vo.FiledVo;
import com.jjugrants.vo.GrantsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StuDao {
    Student query(Student student);//支持模糊查询学号和名字

    Map<String, Object> count();

    Map<String, Object> filedCount();

    List<Student> stuPage(PageBean<Student> pageBean);//按页查询数据

    int filedAdd(Filed filed);

    List<FiledVo> filedVoPage(PageBean<FiledVo> pageBean);

    int filedDel(String id);

    FiledVo getFiled(String id);

    int update(Filed filed);

    Map<String, Object> grantsCount();

    List<GrantsVo> grantsVoPage(PageBean<GrantsVo> pageBean);

    int verify(@Param("id") String id, @Param("pwd") String change);

    int pwdUpdate(@Param("id") String id, @Param("chg") String change);

    int stuDel(String id);
}
