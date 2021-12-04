package com.jjugrants.service.impl;

import com.jjugrants.dao.StuDao;
import com.jjugrants.domain.Student;
import com.jjugrants.service.StuService;
import com.jjugrants.utils.SqlSessionUtil;

public class StuServiceImpl implements StuService {
    private StuDao stuDao = SqlSessionUtil.getSqlSession().getMapper(StuDao.class);
    @Override
    public Student login(String userName, String password) {
        return stuDao.login(userName,password);
    }
}
