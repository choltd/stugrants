package com.jjugrants.service.impl;

import com.jjugrants.dao.TchDao;
import com.jjugrants.domain.Teacher;
import com.jjugrants.service.TchService;
import com.jjugrants.utils.SqlSessionUtil;

public class TchServiceImpl implements TchService {
    private TchDao tchDao = SqlSessionUtil.getSqlSession().getMapper(TchDao.class);
    @Override
    public Teacher login(String sequence, String password) {
        return tchDao.login(sequence, password);
    }
}
