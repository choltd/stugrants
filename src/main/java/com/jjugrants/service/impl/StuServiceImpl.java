package com.jjugrants.service.impl;

import com.jjugrants.dao.StuDao;
import com.jjugrants.domain.Filed;
import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Student;
import com.jjugrants.service.StuService;
import com.jjugrants.utils.SqlSessionUtil;
import com.jjugrants.vo.FiledVo;
import com.jjugrants.vo.GrantsVo;

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
    public boolean filedAdd(Filed filed) {
        return stuDao.filedAdd(filed) == 1;
    }

    @Override
    public PageBean<FiledVo> filedList(PageBean<FiledVo> pageBean) {
        int count = 0;
        Map<String, Object> map = stuDao.filedCount();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        if (count != 0) {
            pageBean.setTotalRecord(count);
        }
        List<FiledVo> filedVos = stuDao.filedVoPage(pageBean);
        pageBean.setList(filedVos);
        return pageBean;
    }

    @Override
    public boolean filedDel(String id) {
        return stuDao.filedDel(id) == 1;
    }

    @Override
    public FiledVo getFiled(String id) {
        return stuDao.getFiled(id);
    }

    @Override
    public boolean update(Filed filed) {
        return stuDao.update(filed) == 1;
    }

    @Override
    public PageBean<GrantsVo> grantsPage(PageBean<GrantsVo> pageBean) {
        int count = 0;
        Map<String, Object> map = stuDao.grantsCount();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        if (count != 0) {
            pageBean.setTotalRecord(count);
        }
        List<GrantsVo> grantsVos = stuDao.grantsVoPage(pageBean);
        pageBean.setList(grantsVos);
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
