package com.jjugrants.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1");
        String path = request.getServletPath();
        // response.sendRedirect(request.getContextPath() + "/static/index.html");  “/”代表localhost:8080  request.getContextPath()获取项目名
        // request.getRequestDispatcher("/static/index.html").forward(request, response);   “/”代表localhost:8080/项目名

        //判断Ajax请求  if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){}
        if(path.startsWith("/admin")){
            boolean flag = back(request);
            if(!flag){
                response.sendRedirect("/admin/sign.html");
                return flag;
            }else {
                return flag;
            }
        }else if (path.startsWith("/teacher")){
            boolean flag = back(request);
            if(!flag){
                response.sendRedirect("/teacher/tchLogin.html");
                return flag;
            }else {
                return flag;
            }
        }else if(path.startsWith("/student")){
            boolean flag = back(request);
            if(!flag){
                response.sendRedirect("/Student/stuLogin.html");
                return flag;
            }else {
                return flag;
            }
        }
        return false;

    }

    public boolean back(HttpServletRequest request){
        return request.getSession().getAttribute("LOGIN") != null ;
    }
}
