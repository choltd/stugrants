package com.jjugrants.service.impl;

import com.jjugrants.dao.AdminDao;
import com.jjugrants.dao.StuDao;
import com.jjugrants.dao.TchDao;
import com.jjugrants.domain.*;
import com.jjugrants.service.AdminService;
import com.jjugrants.utils.SqlSessionUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = SqlSessionUtil.getSqlSession().getMapper(AdminDao.class);
    private final StuDao stuDao = SqlSessionUtil.getSqlSession().getMapper(StuDao.class);
    private final TchDao tchDao = SqlSessionUtil.getSqlSession().getMapper(TchDao.class);

    @Override
    public boolean login(Admin admin) {
        return adminDao.login(admin) != null;
    }

    @Override
    public Map<String, Object> getCharts() {
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> stuMap = stuDao.count();
        stuMap.put("name", "student");
        Map<String, Object> applyMap = stuDao.applyCount();
        applyMap.put("name", "apply");
        Map<String, Object> tchMap = tchDao.count();
        tchMap.put("name", "teacher");
        Map<String, Object> examineMap = tchDao.examineCount();
        examineMap.put("name", "examine");
        Map<String, Object> subsidizeMap = adminDao.subsidizeCount();
        subsidizeMap.put("name", "subsidize");
        dataList.add(stuMap);
        dataList.add(applyMap);
        dataList.add(tchMap);
        dataList.add(examineMap);
        dataList.add(subsidizeMap);
        Map<String, Object> map = new HashMap<>();
        map.put("dataList",dataList);
        return map;
    }

    @Override
    public boolean examineDel(String id) {
        return adminDao.examineDel(id) == 1;
    }

    @Override
    public PageBean<ViewResult> vrPage(PageBean<ViewResult> pageBean) {
        int count = 0;
        Map<String, Object> map = adminDao.subsidizeCount();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        if (count != 0) {
            pageBean.setTotalRecord(count);
        }
        pageBean.setList(adminDao.vrPage(pageBean));
        return pageBean;
    }

    @Override
    public boolean subsidizeDel(String id) {
        return adminDao.subsidizeDel(id) == 1;
    }

    @Override
    public PageBean<ViewApply> vaPage(PageBean<ViewApply> vaPageBean) {
        int count = 0;
        Map<String, Object> map = adminDao.vaCount();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        if (count != 0) {
            vaPageBean.setTotalRecord(count);
        }
        vaPageBean.setList(adminDao.vaPage(vaPageBean));
        return vaPageBean;
    }

    @Override
    public List<Tips> tips() {
        return adminDao.tips();
    }

    @Override
    public boolean applyAdd(Apply apply, String sequence) {
        return adminDao.applyAdd(apply,sequence) == 1;
    }
}
