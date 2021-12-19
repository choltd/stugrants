$(function () {
    $("#account").focus();
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
        sign();
    })
    $("#password").keydown(function (event) {
        if(event.keyCode === 13){
            sign();
        }
    })

});

function sign() {
    if ($("#account").val() === "") {
        $("#accountError").css("display", "block");
    } else if ($("#password").val() === "") {
        $("#passwordError").text("请输入密码").css("display", "block");
    } else{
        $.ajax({
            url:"/tch?action=login",
            data:{"account":$("#account").val(),"password":$("#password").val()},
            dataType:"json",
            type:"post",
            success:function(data){
                if (data !== null) {
                    window.location.href = "teacher.html";
                } else {
                    $("#passwordError").text("用户名或密码错误").css("display", "block");
                }
            }
        })
    }
}