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

    int subsidizeDel(String id);

    Map<String, Object> vaCount();

    List<ViewApply> vaPage(PageBean<ViewApply> vaPageBean);

    List<Tips> tips();

    int applyAdd(@Param("apply") Apply apply, @Param("sequence") String sequence);
}
