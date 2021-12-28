package com.jjugrants.service;

import com.jjugrants.domain.*;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin login(Admin admin);

    Map<String, Object> getCharts();

    boolean examineDel(String id);

    PageBean<ViewResult> vrPage(PageBean<ViewResult> pageBean);

    boolean subsidizeDel(String id);

    PageBean<ViewApply> vaPage(PageBean<ViewApply> vaPageBean);

    List<Tips> tips();

    boolean applyAdd(Apply apply, String sequence);

    PageBean<ViewResult> examinePage(PageBean<ViewResult> vePageBean);

    boolean pwdUpdate(String adminId, String password, String change);

    List<Stuclass> classname();

    boolean stuAdd(Student student);

    boolean tchAdd(Teacher teacher);
}
