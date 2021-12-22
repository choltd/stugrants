package com.jjugrants.service;

import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Review;
import com.jjugrants.domain.Teacher;
import com.jjugrants.vo.ReviewVo;

public interface TchService {
    Teacher query(Teacher teacher);

    PageBean<Teacher> queryList(PageBean<Teacher> pageBean);

    boolean tchDel(String id);

    PageBean<ReviewVo> reviewVoPage(PageBean<ReviewVo> rvpb);
}
