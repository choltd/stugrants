package com.jjugrants.service.impl;

import com.jjugrants.dao.StuDao;
import com.jjugrants.domain.*;
import com.jjugrants.service.StuService;
import com.jjugrants.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class StuServiceImpl implements StuService {
    private final StuDao stuDao = SqlSessionUtil.getSqlSession().getMapper(StuDao.class);

    @Override
    public Student query(Student student) {
        return stuDao.query(student);
    }

    @Override
    public PageBean<Student> queryList(PageBean<Student> pageBean) throws Exception {
        int count = 0;
        Map<String, Object> map = stuDao.count();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        if (count != 0) {
            pageBean.setTotalRecord(count);
        }
        List<Student> students = stuDao.stuPage(pageBean);
        pageBean.setList(students);
        return pageBean;
    }

    @Override
    public boolean applydAdd(Apply apply) {
        return stuDao.applyAdd(apply) == 1;
    }

    @Override
    public PageBean<ViewApply> viewApplyPage(PageBean<ViewApply> pageBean, String sequence) {
        int count = 0;
        Map<String, Object> map = stuDao.vaCount(sequence);
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        if (count != 0) {
            pageBean.setTotalRecord(count);
        }
        List<ViewApply> viewApplies = stuDao.viewApplyPage(pageBean,sequence);
        pageBean.setList(viewApplies);
        return pageBean;
    }

    @Override
    public boolean applyDel(String id) {
        return stuDao.applyDel(id) == 1;
    }

    @Override
    public ViewApply getApply(String id) {
        return stuDao.getApply(id);
    }

    @Override
    public boolean update(Apply apply) {
        return stuDao.update(apply) == 1;
    }

    @Override
    public PageBean<ViewResult> viewResultPage(PageBean<ViewResult> pageBean) {
        int count = 0;
        Map<String, Object> map = stuDao.subsidizeCount();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        if (count != 0) {
            pageBean.setTotalRecord(count);
        }
        List<ViewResult> viewResults = stuDao.viewResultPage(pageBean);
        pageBean.setList(viewResults);
        return pageBean;
    }

    @Override
    public boolean pwdUpdate(String id, String password, String change) {
        if (stuDao.verify(id, password) == 1) {
            return stuDao.pwdUpdate(id, change) == 1;
        } else {
            return false;
        }
    }

    @Override
    public boolean stuDel(String id) {
        return stuDao.stuDel(id) == 1;
    }
}
