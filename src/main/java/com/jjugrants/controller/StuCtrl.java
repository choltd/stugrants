package com.jjugrants.controller;

import com.jjugrants.domain.*;
import com.jjugrants.service.StuService;
import com.jjugrants.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/stu")
public class StuCtrl {

    @Autowired
    private StuService stuService;

    @GetMapping("/login")
    private StudentVo login(Student student, HttpServletRequest req) {
        StudentVo studentVo = stuService.query(student);
        if (studentVo != null) {
            req.getSession().setAttribute("LOGIN", 1);
        }
        return studentVo;
    }

    @PostMapping("/applyAdd")
    private boolean applyAdd(Apply apply) {
        return stuService.applydAdd(apply);
    }

    @GetMapping("/vaPage")
    private PageBean<ViewApply> vaPage(PageBean<ViewApply> pageBean, String sequence) throws Exception {
        return stuService.viewApplyPage(pageBean, sequence);
    }

    @DeleteMapping("/applyDel")
    private Object applyDel(String applyId) {
        return stuService.applyDel(applyId);
    }

    @GetMapping("/applyEdit")
    private ViewApply applyEdit(String applyId) {
        return stuService.getApply(applyId);
    }

    @PutMapping("/update")
    private Object update(Apply apply) {
        return stuService.update(apply);
    }

    @GetMapping("/vrPage")
    private PageBean<ViewResult> vrPage(PageBean<ViewResult> pageBean) {
        return stuService.viewResultPage(pageBean);
    }

    @PutMapping("/pwdUpdate")
    private Object pwdUpdate(String studentId, String password, String change) {
        return stuService.pwdUpdate(studentId, password, change);
    }
}
