<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="static/css/admin/workbench.css" type="text/css" rel="stylesheet">
</head>

<body>
<div id="content">
    <div class="left">
        <div class="form">
            <p>统计</p>
            <table id="tjb">
                <tr>
                    <td>学生</td>
                    <td>申请</td>
                    <td>教师</td>
                    <td>审核</td>
                    <td>资助</td>
                </tr>
            </table>
        </div>
        <div id="ec" class="echarts">

        </div>
    </div>
    <div class="right">
        <p>系统信息</p>
        <ul>
            <li><span style="display: inline-block;width: 20px;"> > </span>新增了一条资助申请，请查看...</li>
            <li><span style="display: inline-block;width: 20px;"> > </span>新增了一条资助申请，请查看...</li>
            <li><span style="display: inline-block;width: 20px;"> > </span>新增了一条资助申请，请查看...</li>
            <li><span style="display: inline-block;width: 20px;"> > </span>新增了一条资助审核，请查看...</li>
            <li><span style="display: inline-block;width: 20px;"> > </span>新增了一条资助审核，请查看...</li>
            <li><span style="margin-left: 45%;">......</span></li>
        </ul>
    </div>
</div>
</body>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/echarts.min.js"></script>
<script>
    $(function () {
        getCharts();
    })

    function getCharts() {
        $.ajax({
            url: "admin?act=getCharts",
            dataType: "json",
            type: "get",
            success: function (data) {
                var html = "<tr>";
                var arr = new Array();
                $.each(data.dataList, function (i, e) {
                    html += "<td><a href=''>" + e.value + "</a></td>";
                    arr.push(e.name);
                })
                $("#tjb").append(html);
                var chartDom = document.getElementById('ec');
                var myChart = echarts.init(chartDom);
                var option;

                option = {
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        right: '10%',
                        top: 'center',
                        data: arr
                    },
                    series: [
                        {
                            name: '统计',
                            type: 'pie',
                            center: ['45%', '50%'],
                            radius: ['40%', '70%'],
                            avoidLabelOverlap: false,
                            itemStyle: {
                                normal: {
                                    borderColor: '#fff',
                                    borderWidth: 2
                                }
                            },
                            label: {
                                show: true
                            },

                            labelLine: {
                                show: true
                            },
                            data: data.dataList
                        }
                    ]
                };

                option && myChart.setOption(option);

                window.addEventListener("resize", function () {
                    myChart.resize();
                })
                $("#ec").css({"background-color": "#fff", "margin-top": "15px"})
            }
        })
    }

</script>

</html>