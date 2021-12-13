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
        $signin.css("left","44%");
        $signin.css("top", "40%");
        $signin.attr("id","active");
        $.ajax({
            url:"/admin?act=login",
            data:{"account":$("#account").val(),"password":$("#password").val()},
            dataType:"json",
            type:"get",
            success:function(data){
                if(data !== null){
                    var delay = setTimeout(function () {
                        window.location.href = "workspace.jsp";
                        clearTimeout(delay);
                    },1000)
                } else{
                    $("#txt").css("display","block");
                    var time = setTimeout(function () {
                        location.reload();
                        clearTimeout(time);
                    },3000);
                }
            }
        });
    })
})