filedAdd = function (data){
    var flag = ""
    $.ajax({
        url:"/stu?action=filedAdd",
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
function info() {
    return JSON.parse(localStorage.getItem("student"));
}
function convert(time){
    var date = new Date(time)
    var datetime = date.toLocaleString()//.toLocaleDateString() + date.toLocaleTimeString();
    return datetime.replace(/\//g,"-")//.replace(/[\u4e00-\u9fa5]{2}/," ")
}