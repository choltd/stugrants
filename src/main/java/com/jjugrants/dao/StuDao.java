package com.jjugrants.dao;

import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StuDao {
    Student query(Student student);//支持模糊查询学号和名字

    Map<String, Object> count();

    Map<String, Object> countFiled();

    List<Student> pageCount(PageBean<Student> pageBean);//按页查询数据
}
