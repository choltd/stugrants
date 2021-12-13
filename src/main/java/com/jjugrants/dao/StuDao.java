package com.jjugrants.dao;

import com.jjugrants.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface StuDao {
    Student login(@Param("sequence") String sequence, @Param("pwd") String password);

    Map<String, Object> count();

    Map<String, Object> countFiled();
}
