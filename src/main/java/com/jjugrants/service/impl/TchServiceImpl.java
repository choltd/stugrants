package com.jjugrants.service.impl;

import com.jjugrants.dao.TchDao;
import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Review;
import com.jjugrants.domain.Teacher;
import com.jjugrants.service.TchService;
import com.jjugrants.utils.SqlSessionUtil;
import com.jjugrants.vo.ReviewVo;

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
        List<Teacher> teachers = tchDao.tchPage(pageBean);
        pageBean.setList(teachers);
        return pageBean;
    }

    @Override
    public boolean tchDel(String id) {
        return tchDao.tchDel(id) == 1;
    }

    @Override
    public PageBean<ReviewVo> reviewVoPage(PageBean<ReviewVo> rvpb) {
        int count = 0;
        Map<String, Object> map = tchDao.countReview();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }

        if (count != 0) {
            rvpb.setTotalRecord(count);
        }
        List<ReviewVo> reviewVos = tchDao.reviewPage(rvpb);
        rvpb.setList(reviewVos);
        return rvpb;
    }
}
