package com.jjugrants.service;

import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Teacher;

public interface TchService {
    Teacher query(Teacher teacher);

    PageBean<Teacher> queryList(PageBean<Teacher> pageBean);
}
