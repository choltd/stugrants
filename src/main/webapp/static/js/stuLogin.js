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
        if ($("#username").val() == "") {
            $("#usernameError").css("display", "block");
        } else if ($("#password").val() == "") {
            $("#passwordError").text("请输入密码");
            $("#passwordError").css("display", "block");
        } else if($("#username").val() !== "admin" || $("#password").val() !== "123456") {
            $("#passwordError").text("用户名或密码错误");
            $("#passwordError").css("display", "block");
        }
    })
});