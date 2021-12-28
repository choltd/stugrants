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


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@WebServlet("/admin")
public class AdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("act");
        Method method = null;
        try {
            method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);//调用方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPassword(password);
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        Admin admin1 =  adminService.login(admin);
        req.getSession().setAttribute("admin",admin1);
        PrintJson.printJsonObj(resp,admin1);
    }

    private void getCharts(HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        Map<String, Object> map = adminService.getCharts();
        PrintJson.printJsonObj(response, map);
    }

    private void stuPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        PageBean<Student> pageBean = new PageBean<>();
        pageBean.setPageNum(Integer.parseInt(pageNum));
        pageBean.setPageSize(Integer.parseInt(pageSize));
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        PageBean<Student> studentPageBean = stuService.queryList(pageBean);
        PrintJson.printJsonObj(response, studentPageBean);
    }

    private void stuDel(HttpServletRequest request, HttpServletResponse response){
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.stuDel(request.getParameter("studentId"));
        PrintJson.printJsonFlag(response, flag);
    }

    private void tchPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        PageBean<Teacher> pageBean = new PageBean<>();
        pageBean.setPageNum(Integer.parseInt(pageNum));
        pageBean.setPageSize(Integer.parseInt(pageSize));
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        PageBean<Teacher> teacherPageBean = tchService.queryList(pageBean);
        PrintJson.printJsonObj(response, teacherPageBean);
    }

    private void tchDel(HttpServletRequest request, HttpServletResponse response){
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        boolean flag = tchService.tchDel(request.getParameter("id"));
        PrintJson.printJsonFlag(response, flag);
    }

    private void examinePage(HttpServletRequest request, HttpServletResponse response){
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        PageBean<ViewResult> vePageBean = new PageBean<>();
        vePageBean.setPageSize(Integer.parseInt(pageSize));
        vePageBean.setPageNum(Integer.parseInt(pageNum));
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        PageBean<ViewResult> examinePageBean = adminService.examinePage(vePageBean);
        PrintJson.printJsonObj(response,examinePageBean);
    }

    private void examineDel(HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        boolean flag = adminService.examineDel(request.getParameter("id"));
        PrintJson.printJsonFlag(response,flag);
    }

    private void vrPage(HttpServletRequest request, HttpServletResponse response){
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        PageBean<ViewResult> pageBean = new PageBean<>();
        pageBean.setPageNum(Integer.parseInt(pageNum));
        pageBean.setPageSize(Integer.parseInt(pageSize));
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        PageBean<ViewResult> vrPageBean = adminService.vrPage(pageBean);
        PrintJson.printJsonObj(response,vrPageBean);
    }

    private void subsidizeDel(HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        boolean flag = adminService.subsidizeDel(request.getParameter("examineId"));
        PrintJson.printJsonFlag(response,flag);
    }

    private void viewApplyPage(HttpServletRequest request, HttpServletResponse response){
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        PageBean<ViewApply> vaPageBean = new PageBean<>();
        vaPageBean.setPageSize(Integer.parseInt(pageSize));
        vaPageBean.setPageNum(Integer.parseInt(pageNum));
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        PageBean<ViewApply> pageBean = adminService.vaPage(vaPageBean);
        PrintJson.printJsonObj(response,pageBean);
    }

    private void tips(HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        List<Tips> tips = adminService.tips();
        PrintJson.printJsonObj(response, tips);

    }

    private void applyAdd(HttpServletRequest request, HttpServletResponse response){
        Apply apply = new Apply();
        apply.setIllustrate(request.getParameter("illustrate"));
        apply.setTime(DateTimeUtil.getTimestamp());
        apply.setRemark(request.getParameter("remark"));
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        boolean flag = adminService.applyAdd(apply,request.getParameter("sequence"));
        PrintJson.printJsonFlag(response,flag);
    }
    private void pwdUpdate(HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        boolean flag = adminService.pwdUpdate(request.getParameter("adminId"),request.getParameter("password"),request.getParameter("change"));
        PrintJson.printJsonFlag(response,flag);
    }

    private void classname(HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        List<Stuclass> stuclasses = adminService.classname();
        PrintJson.printJsonObj(response,stuclasses);

    }
    private void stuAdd(HttpServletRequest request, HttpServletResponse response){
        Student student = new Student();
        student.setSequence(request.getParameter("sequence"));
        student.setName(request.getParameter("name"));
        student.setIdcard(request.getParameter("idcard"));
        student.setBanknumber(request.getParameter("banknumber"));
        student.setSex(request.getParameter("sex"));
        student.setYear(request.getParameter("year"));
        student.setTelephone(request.getParameter("telephone"));
        student.setStuclassId(Integer.parseInt(request.getParameter("stuclassId")));
        student.setPassword(request.getParameter("idcard").substring(12));
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        boolean flag = adminService.stuAdd(student);
        PrintJson.printJsonFlag(response,flag);
    }

    private void tchAdd(HttpServletRequest request, HttpServletResponse response){
        Teacher teacher = new Teacher();
        teacher.setTeacherName(request.getParameter("teacherName"));
        teacher.setSex(request.getParameter("sex"));
        teacher.setTelephone(request.getParameter("telephone"));
        teacher.setWorknumber(request.getParameter("worknumber"));
        teacher.setPassword("123456");
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        boolean flag = adminService.tchAdd(teacher);
        PrintJson.printJsonFlag(response,flag);

    }

}
