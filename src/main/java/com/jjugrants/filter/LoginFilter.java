package com.jjugrants.filter;

import com.jjugrants.domain.Admin;
import com.jjugrants.vo.StudentVo;
import com.jjugrants.vo.TeacherVo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/static/admin/*", "/static/Student/*", "/static/teacher/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getServletPath();
        if (path.contains("/stuLogin.html") || path.contains("/tchLogin.html") || path.contains("/signin.html")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = req.getSession();
            StudentVo studentVo = (StudentVo) session.getAttribute("studentVo");
            TeacherVo teacherVo = (TeacherVo) session.getAttribute("teacherVo");
            Admin admin = (Admin) session.getAttribute("admin");
            if (studentVo == null && path.contains("/Student/")) {
                resp.sendRedirect(req.getContextPath() + "stuLogin.html");
            }
            if (teacherVo == null && path.contains("/teacher/")) {
                resp.sendRedirect(req.getContextPath() + "tchLogin.html");
            }
            if (admin == null && path.contains("/admin/")) {
                resp.sendRedirect(req.getContextPath() + "signin.html");
            }
            chain.doFilter(request, response);

        }

    }

    @Override
    public void destroy() {

    }
}
