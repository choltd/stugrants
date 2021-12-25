applyAdd = function (data){
    var flag = ""
    $.ajax({
        url:"/stu?action=applyAdd",
        async:false,
        data:data,
        dataType:"json",
        type:"post",
        success:function(data){
            flag = data.success
        }
    })
    return flag
};

function stuInfo() {
    return JSON.parse(localStorage.getItem("student"));
}
function tchInfo() {
    return JSON.parse(localStorage.getItem("teacher"));
}
function convert(time){
    var date = new Date(time)
    var datetime = date.toLocaleDateString() // date.toLocaleTimeString();
    return datetime.replace(/\//g,"-")//.replace(/[\u4e00-\u9fa5]{2}/," ")
}