package com.jjugrants.service.impl;

import com.jjugrants.dao.StuDao;
import com.jjugrants.dao.TchDao;
import com.jjugrants.domain.*;
import com.jjugrants.service.TchService;
import com.jjugrants.utils.SqlSessionUtil;
import com.jjugrants.vo.TeacherVo;

import java.util.List;
import java.util.Map;

public class TchServiceImpl implements TchService {
    private final TchDao tchDao = SqlSessionUtil.getSqlSession().getMapper(TchDao.class);
    private final StuDao stuDao = SqlSessionUtil.getSqlSession().getMapper(StuDao.class);

    @Override
    public TeacherVo query(Teacher teacher) {
        return tchDao.query(teacher);
    }

    @Override
    public PageBean<Teacher> queryList(PageBean<Teacher> pageBean) {
        int count = 0;
        Map<String, Object> map = tchDao.count();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }

        if (count != 0) {
            pageBean.setTotalRecord(count);
        }
        List<Teacher> teachers = tchDao.tchPage(pageBean);
        pageBean.setList(teachers);
        return pageBean;
    }

    @Override
    public boolean tchDel(String id) {
        return tchDao.tchDel(id) == 1;
    }

    @Override
    public PageBean<ViewResult> examinePage(PageBean<ViewResult> vePageBean) {
        int count = 0;
        Map<String, Object> map = tchDao.viewResultCount();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }

        if (count != 0) {
            vePageBean.setTotalRecord(count);
        }
        List<ViewResult> viewExamines = tchDao.examinePage(vePageBean);
        vePageBean.setList(viewExamines);
        return vePageBean;
    }

    @Override
    public PageBean<ViewApply> viewApplyPage(PageBean<ViewApply> vaPageBean, String teacherId) {
        int count = 0;
        Map<String, Object> map = stuDao.applyCountTeacherId(teacherId);
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }

        if (count != 0) {
            vaPageBean.setTotalRecord(count);
        }
        List<ViewApply> viewApplies = tchDao.viewApplyPage(vaPageBean,teacherId);
        vaPageBean.setList(viewApplies);
        return vaPageBean;
    }

    @Override
    public ViewApply applyShow(String applyId) {
        return tchDao.applyShow(applyId);
    }

    @Override
    public boolean applyFail(Examine examine) {
        return tchDao.applyFail(examine) == 1;
    }

    @Override
    public boolean examine(Examine examine) {
        return tchDao.examine(examine) == 1;
    }

    @Override
    public List<ViewResult> searchClassname(String classname) {
        return tchDao.searchClassname(classname);
    }
}
