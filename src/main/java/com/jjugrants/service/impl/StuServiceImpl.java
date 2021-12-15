package com.jjugrants.service.impl;

import com.jjugrants.dao.StuDao;
import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Student;
import com.jjugrants.service.StuService;
import com.jjugrants.utils.SqlSessionUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        List<Student> students = stuDao.pageCount(pageBean);
        pageBean.setList(students);
        return pageBean;
    }
}
