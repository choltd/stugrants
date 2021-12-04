package com.jjugrants.dao;

import com.jjugrants.domain.Student;
import org.apache.ibatis.annotations.Param;

public interface StuDao {
    Student login(@Param("uname") String userName, @Param("pwd") String password);
}
