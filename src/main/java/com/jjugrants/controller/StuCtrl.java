package com.jjugrants.controller;

import com.jjugrants.domain.Student;
import com.jjugrants.service.StuService;
import com.jjugrants.service.impl.StuServiceImpl;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/stu")
public class StuCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        StuService ss = (StuService) ServiceFactory.getService(new StuServiceImpl());
        Student stu = ss.login(userName, password);
        PrintJson.printJsonObj(resp, stu);
    }
}
