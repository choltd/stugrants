var current = null;
$("#account").focus(function () {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: 0,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
$("#password").focus(function () {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -336,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '240 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
$("#submit").focus(function () {
    if (current) current.pause();
    current = anime({
        targets: 'path',
        strokeDashoffset: {
            value: -730,
            duration: 700,
            easing: 'easeOutQuart'
        },
        strokeDasharray: {
            value: '530 1386',
            duration: 700,
            easing: 'easeOutQuart'
        }
    });
});
$(function () {
    $("#submit").click(function () {
        var $signin = $(".signin");
        $(".form").hide();
        $("#vb").hide();
        $signin.css({"left": "44%", "top": "40%"});
        $signin.attr("id", "active");
        $.ajax({
            url: "/admin?act=login",
            data: {
                "account": $("#account").val(),
                "password": $("#password").val()
            },
            dataType: "json",
            type: "get",
            success: function (data) {
                if (data !== null) {
                    if(window.localStorage){
                        localStorage.setItem("admin",JSON.stringify(data));
                    }
                    $("#txt").text("loading").css({"display":"block","color":"#fff"});
                    var delay = setTimeout(function () {
                        window.location.href = "../admin/workspace.html";
                        clearTimeout(delay);
                    }, 1000)
                } else {
                    $("#txt").text("error").css("display", "block");
                    var time = setTimeout(function () {
                        location.reload();
                        clearTimeout(time);
                    }, 3000);
                }
            }
        });
    })
})