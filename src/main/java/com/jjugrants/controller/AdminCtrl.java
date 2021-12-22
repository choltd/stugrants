package com.jjugrants.controller;

import com.jjugrants.domain.*;
import com.jjugrants.service.AdminService;
import com.jjugrants.service.StuService;
import com.jjugrants.service.TchService;
import com.jjugrants.service.impl.AdminServiceImpl;
import com.jjugrants.service.impl.StuServiceImpl;
import com.jjugrants.service.impl.TchServiceImpl;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;
import com.jjugrants.vo.ReviewVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
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
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        Admin admin = adminService.login(account, password);
        PrintJson.printJsonObj(resp, admin);
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
        boolean flag = stuService.stuDel(request.getParameter("id"));
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

    private void reviewVoPage(HttpServletRequest request, HttpServletResponse response){
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        PageBean<ReviewVo> rvpb = new PageBean<>();
        rvpb.setPageSize(Integer.parseInt(pageSize));
        rvpb.setPageNum(Integer.parseInt(pageNum));
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        PageBean<ReviewVo> reviewPageBean = tchService.reviewVoPage(rvpb);
        PrintJson.printJsonObj(response,reviewPageBean);
    }

    private void reviewDel(HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        boolean flag = adminService.reviewDel(request.getParameter("id"));
        PrintJson.printJsonFlag(response,flag);
    }

}
