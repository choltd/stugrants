package com.jjugrants.service.impl;

import com.jjugrants.dao.AdminDao;
import com.jjugrants.dao.StuDao;
import com.jjugrants.dao.TchDao;
import com.jjugrants.domain.Admin;
import com.jjugrants.domain.Student;
import com.jjugrants.service.AdminService;
import com.jjugrants.service.StuService;
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
    public Admin login(String account, String password) {
        return adminDao.login(account, password);
    }

    @Override
    public Map<String, Object> getCharts() {
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> stuMap = stuDao.count();
        stuMap.put("name", "student");
        Map<String, Object> filedMap = stuDao.filedCount();
        filedMap.put("name", "filed");
        Map<String, Object> tchMap = tchDao.count();
        tchMap.put("name", "teacher");
        Map<String, Object> reviewMap = tchDao.countReview();
        reviewMap.put("name", "review");
        Map<String, Object> adminMap = adminDao.countGrants();
        adminMap.put("name", "grants");
        dataList.add(stuMap);
        dataList.add(filedMap);
        dataList.add(tchMap);
        dataList.add(reviewMap);
        dataList.add(adminMap);
        Map<String, Object> map = new HashMap<>();
        map.put("dataList",dataList);
        return map;
    }
}
