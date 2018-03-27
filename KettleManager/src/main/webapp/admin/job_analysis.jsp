<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ETL监控系统主页</title>
<%@include file="header.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/rdb.css"> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/shanghai.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/china.js"></script> 
<script type="text/javascript">

</script>
</head>
<body >
<div id="main_charts" style="width: 1000px;height:500px;"></div> 
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main_charts'));
	option = {
			title : {
		        text:'job调度时间统计(S)',
		        x:'center',
		        y:'top',
		        textStyle : {
		        	fontSize: 18,
		            fontWeight: 'bolder',
		            color: '#333'
		        }
		    },
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    xAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    yAxis : [
		        {
		            type : 'category',
		            data : []
		        }
		    ],
		    grid :[
					{x :'20%'}
		         ],
		    series : [
		        {
		            name:'调度时间',
		            type:'bar',
		            stack: '总量',
		            itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
		            data:[],
		            barWidth: 15,
		            itemStyle:{
                        normal:{
                            color:'#019858'
                        }
                    }
		        }
		       
		    ]
		};
		myChart.setOption(option);
		myChart.showLoading();
		$.ajax({
			 type: "GET",
			 url: "${pageContext.request.contextPath}/admin/jobLog/jobLogAnalysis.do",
			 dataType: "json",
			 success: function(data){
				 myChart.hideLoading();
				 myChart.setOption({        //加载数据图表
					 yAxis: [{
                         data: data.yAxis
                     }],
                     series: [{
                         data: data.series
                     }]
                 });
             }
		});
	
        // 使用刚指定的配置项和数据显示图表。
        
</script>
</body>
</html>