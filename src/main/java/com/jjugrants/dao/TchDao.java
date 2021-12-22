package com.jjugrants.dao;

import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Teacher;
import com.jjugrants.vo.ReviewVo;

import java.util.List;
import java.util.Map;

public interface TchDao {
    Teacher query(Teacher teacher);

    Map<String, Object> count();

    Map<String, Object> countReview();

    List<Teacher> tchPage(PageBean<Teacher> pageBean);

    int tchDel(String id);

    List<ReviewVo> reviewPage(PageBean<ReviewVo> rvpb);
}
