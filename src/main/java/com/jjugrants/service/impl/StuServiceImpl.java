package com.jjugrants.service.impl;

import com.jjugrants.dao.StuDao;
import com.jjugrants.domain.*;
import com.jjugrants.service.StuService;
import com.jjugrants.utils.DateTimeUtil;
import com.jjugrants.vo.StudentVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;

    @Override
    public StudentVo query(Student student) {
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
        Timestamp timestamp = DateTimeUtil.getTimestamp();
        apply.setTime(timestamp);
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

    @Transactional
    @Override
    public boolean applyDel(String id) {
        if(stuDao.examine(id) == 1){
            stuDao.examineDel(id);
        }
        return stuDao.applyDel(id) == 1;
    }

    @Override
    public ViewApply getApply(String id) {
        return stuDao.getApply(id);
    }

    @Override
    public boolean update(Apply apply) {
        apply.setTime(DateTimeUtil.getTimestamp());
        return stuDao.update(apply) == 1;
    }

    @Override
    public PageBean<ViewResult> viewResultPage(PageBean<ViewResult> pageBean) {
        int count = 0;
        Map<String, Object> map = stuDao.subsidizeCount();
        for (Object value : map.values()) {
            count = Integer.parseInt(String.valueOf(value));
        }
        //10个名额才返回
        if (count != 0 ) {
            pageBean.setTotalRecord(count);
        }
        int count1 = stuDao.applyCount1();
        int count2 = stuDao.examineCount1();
        if(count == 10 && count1 == count2){
            List<ViewResult> viewResults = stuDao.viewResultPage(pageBean);
            pageBean.setList(viewResults);
        }
        return pageBean;
    }

    @Transactional
    @Override
    public boolean pwdUpdate(String id, String password, String change) {
        if (stuDao.verify(id, password) == 1) {
            return stuDao.pwdUpdate(id, change) == 1;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean stuDel(String id) {
        if(stuDao.applyCount2(id) ==1){
            if(applyDel(String.valueOf(stuDao.getApplyId(id)))){
                return stuDao.stuDel(id) == 1;
            }
        }
        return false;
    }
}
