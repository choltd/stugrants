package com.jjugrants.controller;

import com.jjugrants.domain.*;
import com.jjugrants.service.StuService;
import com.jjugrants.service.impl.StuServiceImpl;
import com.jjugrants.utils.DateTimeUtil;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.sql.Timestamp;

@WebServlet("/stu")
public class StuCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        Method method = null;
        try {
            method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);//反射获取方法名
            if (method != null) {
                method.invoke(this, req, resp);//调用方法
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String sequence = req.getParameter("account");
        String password = req.getParameter("password");
        Student student = new Student();
        student.setSequence(sequence);
        student.setPassword(password);
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        Student stu = stuService.query(student);
        PrintJson.printJsonObj(resp, stu);
    }

    private void applydAdd(HttpServletRequest request, HttpServletResponse response){
        String studentId = request.getParameter("studentId");
        String illustrate = request.getParameter("illustrate");
        String remark = request.getParameter("remark");
        Timestamp timestamp = DateTimeUtil.getTimestamp();
        Apply apply = new Apply();
        apply.setStudentId(Integer.parseInt(studentId));
        apply.setIllustrate(illustrate);
        apply.setRemark(remark);
        apply.setTime(timestamp);
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.applydAdd(apply);
        PrintJson.printJsonFlag(response,flag);
    }

    private void viewApplyPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        PageBean<ViewApply> pageBean = new PageBean<>();
        pageBean.setPageNum(Integer.parseInt(pageNum));
        pageBean.setPageSize(Integer.parseInt(pageSize));
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        PageBean<ViewApply> viewApplyPageBean = stuService.viewApplyPage(pageBean, request.getParameter("sequence"));
        PrintJson.printJsonObj(response, viewApplyPageBean);
    }

    private void applyDel(HttpServletRequest request, HttpServletResponse response){
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.applyDel(request.getParameter("id"));
        PrintJson.printJsonFlag(response,flag);
    }

    private void applyEdit(HttpServletRequest request, HttpServletResponse response){
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        ViewApply viewApply = stuService.getApply(request.getParameter("id"));
        PrintJson.printJsonObj(response,viewApply);
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        Apply apply = new Apply();
        apply.setApplyId(Integer.parseInt(request.getParameter("id")));
        apply.setIllustrate(request.getParameter("illustrate"));
        apply.setRemark(request.getParameter("remark"));
        apply.setTime(DateTimeUtil.getTimestamp());
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.update(apply);
        PrintJson.printJsonFlag(response,flag);
    }

    private void viewResultPage(HttpServletRequest request, HttpServletResponse response){
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        String studentId = request.getParameter("studentId");
        PageBean<ViewResult> pageBean = new PageBean<>();
        pageBean.setPageNum(Integer.parseInt(pageNum));
        pageBean.setPageSize(Integer.parseInt(pageSize));
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        PageBean<ViewResult> viewResultPage =  stuService.viewResultPage(pageBean);
        PrintJson.printJsonObj(response,viewResultPage);
    }

    private void pwdUpdate(HttpServletRequest request, HttpServletResponse response){
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.pwdUpdate(request.getParameter("id"),request.getParameter("password"),request.getParameter("change"));
        PrintJson.printJsonFlag(response,flag);
    }
}
