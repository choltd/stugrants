package com.jjugrants.service;

import com.jjugrants.domain.*;

import java.util.List;
import java.util.Map;

public interface AdminService {
    boolean login(Admin admin);

    Map<String, Object> getCharts();

    boolean examineDel(String id);

    PageBean<ViewResult> vrPage(PageBean<ViewResult> pageBean);

    boolean subsidizeDel(String id);

    PageBean<ViewApply> vaPage(PageBean<ViewApply> vaPageBean);

    List<Tips> tips();
}
