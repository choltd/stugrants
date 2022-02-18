package com.jjugrants.controller;

import com.jjugrants.domain.*;
import com.jjugrants.service.TchService;
import com.jjugrants.service.impl.TchServiceImpl;
import com.jjugrants.utils.DateTimeUtil;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;
import com.jjugrants.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
@Controller
@RequestMapping("/tch")
public class TchCtrl {
    @Autowired
    private TchService tchService;

    @GetMapping("/login")
    private TeacherVo login(Teacher teacher, HttpServletRequest req) {
        TeacherVo teacherVo = tchService.query(teacher);
        if(teacherVo != null){
            req.getSession().setAttribute("LOGIN", 1);
        }
        return teacherVo;
    }

    @GetMapping("/vaPage")
    private PageBean<ViewApply> vaPage(PageBean<ViewApply> pageBean, String teacherId) {
        return tchService.viewApplyPage(pageBean, teacherId);
    }

    @GetMapping("/applyShow")
    private ViewApply applyShow(String applyId) {
         return tchService.applyShow(applyId);
    }

    @PutMapping("/applyFail")
    private Object applyFail(Examine examine) {
        return tchService.applyFail(examine);
    }

    @PutMapping("/examine")
    private Object examine(Examine examine) {
        return tchService.examine(examine);
    }

    @GetMapping("/examinePage")
    private PageBean<ViewResult> examinePage(PageBean<ViewResult> pageBean) {
        return tchService.examinePage(pageBean);

    }

    @GetMapping("/classname")
    private List<ViewResult> Classname(String classname) {
        return tchService.searchClassname(classname);
    }

    @PutMapping("/pwdUpdate")
    private Object pwdUpdate(String teacherId, String password, String change) {
        return tchService.pwdUpdate(teacherId, password, change);
    }

}
