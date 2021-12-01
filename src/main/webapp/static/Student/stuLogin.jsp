<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>学生登录</title>
    <base href="<%=basePath%>">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="static/css/student/stuLogin.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="stu_page_wrappers">
        <div class="stu_login_content">
            <div class="drxx byzs">
                <img class="dlsm" src="static/image/dlsm.jpg" alt="">
            </div>
            <div class="dz_left">
                <img class="contentbg show" src="static/image/jjxy.jpg" alt="">
            </div>
            <div class="stu_login_left">

            </div>
            <div class="stu_login_right">
                <div class="stu_tab">
                    <div class="stuLogin">学生身份认证</div>
                    <div class="clearfloat"></div>
                    <div class="stu_tab_content">
                        <div class="stu_tab_content_item">
                            <form id="stuLoginForm" role="form">
                                <p>
                                    <span class="dz_label">用户名</span>
                                    <input id="username" name="username" placeholder="职工号/学号" class="stu_input"
                                        type="text" value="" />
                                    <span id="usernameError" style="display:none;" class="stu_error">请输入用户名</span>
                                </p>
                                <p>
                                    <span class="dz_label">密码</span>
                                    <input id="password" placeholder="密码" class="stu_input" type="password" value=""
                                        autocomplete="off" />
                                    <input id="passwordEncrypt" name="password" style="display:none;" type="text"
                                        value="" />
                                    <span id="passwordError" style="display:none;" class="stu_error"></span>
                                </p>
                                <p style="margin-bottom: 20px;">
                                    <input type="button" id="dlBtn" class="stu_login_btn primary full_width" value="登录">
                                    </input>
                                </p>
                                <span class="drsm">登录说明</span>
                                <span id="wjmm" class="stu_login_wjmm">
                                    <small>忘记密码?</small>
                                </span>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript" src="static/js/stuLogin.js"></script>

</html>