package com.jjugrants.dao;

import com.jjugrants.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AdminDao {

    Admin login(@Param("account") String account, @Param("pwd") String password);


    Map<String, Object> countGrants();

    int reviewDel(String id);
}
