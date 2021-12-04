$(function () {
    $("#username").focus();
    $("#wjmm").click(function () {
        alert("请向管理员确认！");
    })
    $('.drsm').mouseover(function () {
        $(".dz_left").hide();
        $('.drxx').removeClass('byzs');
    }).mouseout(function () {
        $(".dz_left").show();
        $('.drxx').addClass('byzs');
    })
    $("#dlBtn").click(function () {
        if ($("#username").val() === "") {
            $("#usernameError").css("display", "block");
        } else if ($("#password").val() === "") {
            $("#passwordError").text("请输入密码").css("display", "block");
        } else{
            $.ajax({
                url:"/stu?action=login",
                data:{"userName":$("#username").val(),"password":$("#password").val()},
                dataType:"json",
                type:"post",
                success:function(data){
                    if (data !== null) {
                        window.location.href = "static/Student/test.html";
                    } else { 
                        $("#passwordError").text("用户名或密码错误").css("display", "block");
                    }
                }
            })
        }
    })
});