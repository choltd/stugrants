package com.jjugrants.service;

import com.jjugrants.domain.Filed;
import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Student;
import com.jjugrants.vo.FiledVo;
import com.jjugrants.vo.GrantsVo;

public interface StuService {
    Student query(Student student);

    PageBean<Student> queryList(PageBean<Student> pageBean) throws Exception;

    boolean filedAdd(Filed filed);

    PageBean<FiledVo> filedList(PageBean<FiledVo> pageBean);

    boolean filedDel(String id);

    FiledVo getFiled(String id);

    boolean update(Filed filed);

    PageBean<GrantsVo> grantsPage(PageBean<GrantsVo> pageBean);

    boolean pwdUpdate(String id, String password, String change);

    boolean stuDel(String id);
}
