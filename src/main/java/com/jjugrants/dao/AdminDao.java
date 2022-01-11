package com.jjugrants.dao;

import com.jjugrants.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminDao {

    Admin login(Admin admin);

    Map<String, Object> subsidizeCount();

    int examineDel(String id);

    List<ViewResult> vrPage(PageBean<ViewResult> pageBean);

    Map<String, Object> vaCount();

    List<ViewApply> vaPage(PageBean<ViewApply> vaPageBean);

    List<Tips> tips();

    int applyAdd(@Param("apply") Apply apply, @Param("sequence") String sequence);

    Map<String, Object> examineCount();

    List<ViewResult> vePage(PageBean<ViewResult> vePageBean);

    int verify(@Param("adminId") String adminId, @Param("pwd") String password);

    int pwdUpdate(@Param("adminId") String adminId, @Param("chg") String change);
}
