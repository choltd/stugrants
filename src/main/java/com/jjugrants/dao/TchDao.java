package com.jjugrants.dao;

import com.jjugrants.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface TchDao {
    Teacher login(@Param("workId") String workId, @Param("pwd") String password);

    Map<String, Object> count();

    Map<String, Object> countReview();
}
