package com.jjugrants.controller;

import com.jjugrants.domain.Teacher;
import com.jjugrants.service.TchService;
import com.jjugrants.service.impl.TchServiceImpl;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@WebServlet("/tch")
public class TchCtrl extends HttpServlet {
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
        String workId = req.getParameter("account");
        String password = req.getParameter("password");
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        Teacher teacher = tchService.login(workId, password);
        PrintJson.printJsonObj(resp, teacher);
    }

}
