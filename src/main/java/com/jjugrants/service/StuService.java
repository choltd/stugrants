package com.jjugrants.service;

import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Student;

public interface StuService {
    Student query(Student student);

    PageBean<Student> queryList(PageBean<Student> pageBean) throws Exception;
}
