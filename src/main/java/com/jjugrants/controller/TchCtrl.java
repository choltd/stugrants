package com.jjugrants.controller;

import com.jjugrants.domain.*;
import com.jjugrants.service.TchService;
import com.jjugrants.service.impl.TchServiceImpl;
import com.jjugrants.utils.DateTimeUtil;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;
import com.jjugrants.vo.TeacherVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

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
        String Worknumber = req.getParameter("account");
        String password = req.getParameter("password");
        Teacher tch = new Teacher();
        tch.setWorknumber(Worknumber);
        tch.setPassword(password);
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        TeacherVo teacherVo = tchService.query(tch);
        PrintJson.printJsonObj(resp, teacherVo);
    }

    private void viewApplyPage(HttpServletRequest request, HttpServletResponse response){
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        PageBean<ViewApply> vaPageBean = new PageBean<>();
        vaPageBean.setPageSize(Integer.parseInt(pageSize));
        vaPageBean.setPageNum(Integer.parseInt(pageNum));
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        PageBean<ViewApply> pageBean = tchService.viewApplyPage(vaPageBean,request.getParameter("teacherId"));
        PrintJson.printJsonObj(response,pageBean);
    }

    private void applyShow(HttpServletRequest request, HttpServletResponse response){
        String applyId = request.getParameter("applyId");
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        ViewApply viewApply = tchService.applyShow(applyId);
        PrintJson.printJsonObj(response,viewApply);
    }

    private void applyFail(HttpServletRequest request, HttpServletResponse response){
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        Examine examine = new Examine();
        examine.setApplyId(Integer.parseInt(request.getParameter("applyId")));
        examine.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
        examine.setTime(DateTimeUtil.getTimestamp());
        examine.setState("否");
        boolean flag = tchService.applyFail(examine);
        PrintJson.printJsonFlag(response,flag);
    }

    private void examine(HttpServletRequest request, HttpServletResponse response){
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        Examine examine = new Examine();
        examine.setApplyId(Integer.parseInt(request.getParameter("applyId")));
        examine.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
        examine.setTime(DateTimeUtil.getTimestamp());
        examine.setState("是");
        boolean flag = tchService.examine(examine);
        PrintJson.printJsonFlag(response,flag);
    }

    private void examinePage(HttpServletRequest request, HttpServletResponse response){
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        PageBean<ViewResult> vrPageBean = new PageBean<>();
        vrPageBean.setPageNum(Integer.parseInt(pageNum));
        vrPageBean.setPageSize(Integer.parseInt(pageSize));
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        PageBean<ViewResult> pageBean = tchService.examinePage(vrPageBean);
        PrintJson.printJsonObj(response,pageBean);
    }

    private void searchClassname(HttpServletRequest request, HttpServletResponse response){
        String classname = request.getParameter("classname");
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        List<ViewResult> viewResults =  tchService.searchClassname(classname);
        PrintJson.printJsonObj(response,viewResults);
    }

    private void pwdUpdate(HttpServletRequest request, HttpServletResponse response){
        TchService tchService = (TchService) ServiceFactory.getService(new TchServiceImpl());
        boolean flag = tchService.pwdUpdate(request.getParameter("teacherId"),request.getParameter("password"),request.getParameter("change"));
        PrintJson.printJsonFlag(response,flag);
    }

}
