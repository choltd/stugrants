package com.jjugrants.controller;

import com.jjugrants.domain.Filed;
import com.jjugrants.domain.PageBean;
import com.jjugrants.domain.Student;
import com.jjugrants.service.StuService;
import com.jjugrants.service.impl.StuServiceImpl;
import com.jjugrants.utils.DateTimeUtil;
import com.jjugrants.utils.PrintJson;
import com.jjugrants.utils.ServiceFactory;
import com.jjugrants.vo.FiledVo;
import com.jjugrants.vo.GrantsVo;
import com.sun.net.httpserver.spi.HttpServerProvider;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;

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

    private void filedAdd(HttpServletRequest request, HttpServletResponse response){
        String studentId = request.getParameter("studentId");
        String illustrate = request.getParameter("illustrate");
        String rating = request.getParameter("rating");
        String remark = request.getParameter("remark");
        Timestamp timestamp = DateTimeUtil.getTimestamp();
        Filed filed = new Filed();
        filed.setStudentId(Integer.parseInt(studentId));
        filed.setIllustrate(illustrate);
        filed.setRating(rating);
        filed.setRemark(remark);
        filed.setTime(timestamp);
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.filedAdd(filed);
        PrintJson.printJsonFlag(response,flag);
    }

    private void filedVoPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        PageBean<FiledVo> pageBean = new PageBean<>();
        pageBean.setPageNum(Integer.parseInt(pageNum));
        pageBean.setPageSize(Integer.parseInt(pageSize));
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        PageBean<FiledVo> filedVoPageBean = stuService.filedList(pageBean);
        PrintJson.printJsonObj(response, filedVoPageBean);
    }

    private void filedDel(HttpServletRequest request, HttpServletResponse response){
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.filedDel(request.getParameter("id"));
        PrintJson.printJsonFlag(response,flag);
    }

    private void filedEdit(HttpServletRequest request, HttpServletResponse response){
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        FiledVo filedvo = stuService.getFiled(request.getParameter("id"));
        PrintJson.printJsonObj(response,filedvo);
    }

    private void update(HttpServletRequest request, HttpServletResponse response){
        Filed filed = new Filed();
        filed.setId(Integer.parseInt(request.getParameter("id")));
        filed.setIllustrate(request.getParameter("illustrate"));
        filed.setRating(request.getParameter("rating"));
        filed.setRemark(request.getParameter("remark"));
        filed.setTime(DateTimeUtil.getTimestamp());
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.update(filed);
        PrintJson.printJsonFlag(response,flag);
    }

    private void grantsPage(HttpServletRequest request, HttpServletResponse response){
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        PageBean<GrantsVo> pageBean = new PageBean<>();
        pageBean.setPageNum(Integer.parseInt(pageNum));
        pageBean.setPageSize(Integer.parseInt(pageSize));
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        PageBean<GrantsVo> voPageBean =  stuService.grantsPage(pageBean);
        PrintJson.printJsonObj(response,voPageBean);
    }

    private void pwdUpdate(HttpServletRequest request, HttpServletResponse response){
        StuService stuService = (StuService) ServiceFactory.getService(new StuServiceImpl());
        boolean flag = stuService.pwdUpdate(request.getParameter("id"),request.getParameter("password"),request.getParameter("change"));
        PrintJson.printJsonFlag(response,flag);
    }
}
