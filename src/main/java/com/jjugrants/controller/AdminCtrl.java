package com.jjugrants.controller;

import com.jjugrants.domain.Admin;
import com.jjugrants.domain.Student;
import com.jjugrants.service.AdminService;
import com.jjugrants.service.StuService;
import com.jjugrants.service.impl.AdminServiceImpl;
import com.jjugrants.service.impl.StuServiceImpl;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;

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
            method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);//反射获取方法名
            if (method != null) {
                method.invoke(this, req, resp);//调用方法
            }
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
        Map<String,Object> map =  adminService.getCharts();
        PrintJson.printJsonObj(response,map);
    }

}
