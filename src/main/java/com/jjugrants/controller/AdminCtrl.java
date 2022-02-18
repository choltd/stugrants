package com.jjugrants.controller;

import com.jjugrants.domain.*;
import com.jjugrants.service.AdminService;
import com.jjugrants.service.StuService;
import com.jjugrants.service.TchService;
import com.jjugrants.service.impl.AdminServiceImpl;
import com.jjugrants.service.impl.StuServiceImpl;
import com.jjugrants.service.impl.TchServiceImpl;
import com.jjugrants.utils.DateTimeUtil;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminCtrl {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StuService stuService;
    @Autowired
    private TchService tchService;

    @GetMapping("/login")
    private boolean login(Admin admin, HttpServletRequest req) {
        if (adminService.login(admin) != null) {
            req.getSession().setAttribute("LOGIN", "1");
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/getCharts")
    private Map<String, Object> getCharts() {
        return adminService.getCharts();
    }

    @GetMapping("/stuPage")
    private PageBean<Student> stuPage(PageBean<Student> pageBean) throws Exception {
        return stuService.queryList(pageBean);
    }

    @DeleteMapping("/stuDel")
    private boolean stuDel(String studentId) {
        return stuService.stuDel(studentId);

    }

    @GetMapping("/tchPage")
    private PageBean<Teacher> tchPage(PageBean<Teacher> pageBean) throws Exception {
        return tchService.queryList(pageBean);
    }

    @DeleteMapping("/tchDel")
    private boolean tchDel(String id) {
        return tchService.tchDel(id);
    }

    @GetMapping("/examinePage")
    private PageBean<ViewResult> examinePage(PageBean<ViewResult> pageBean) {
        return adminService.examinePage(pageBean);
    }

    @DeleteMapping("/examineDel")
    private boolean examineDel(String id) {
        return adminService.examineDel(id);
    }

    @GetMapping("/vrPage")
    private PageBean<ViewResult> vrPage(PageBean<ViewResult> pageBean) {
        return adminService.vrPage(pageBean);
    }

    @DeleteMapping("/subsidizeDel")
    private boolean subsidizeDel(String examineId) {
        return adminService.subsidizeDel(examineId);
    }

    @GetMapping("/vaPage")
    private PageBean<ViewApply> viewApplyPage(PageBean<ViewApply> pageBean) {
        return adminService.vaPage(pageBean);
    }

    @GetMapping("/tips")
    private List<Tips> tips() {
        return adminService.tips();
    }

    @PutMapping("/pwdUpdate")
    private boolean pwdUpdate(String adminId, String password, String change) {
        return adminService.pwdUpdate(adminId, password, change);
    }

    @GetMapping("/classname")
    private List<Stuclass> classname() {
        return adminService.classname();
    }

    @PostMapping("/stuAdd")
    private boolean stuAdd(Student student) {
        return adminService.stuAdd(student);
    }

    @PostMapping("/tchAdd")
    private boolean tchAdd(Teacher teacher) {
        return adminService.tchAdd(teacher);
    }
}
