package com.jjugrants.service.impl;

import com.jjugrants.dao.TchDao;
import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Teacher;
import com.jjugrants.service.TchService;
import com.jjugrants.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class TchServiceImpl implements TchService {
    private final TchDao tchDao = SqlSessionUtil.getSqlSession().getMapper(TchDao.class);
    @Override
    public Teacher query(Teacher teacher) {
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
        List<Teacher> teachers = tchDao.pageCount(pageBean);
        pageBean.setList(teachers);
        return pageBean;
    }
}
