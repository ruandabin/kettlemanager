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


<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main_charts'));
	option = {
			title : {
		        text:'上海市地图',
		        textStyle : {
		            color: 'blue'
		        }
		    },
		    series : [
		        {
		            name: '上海',
		            type: 'map',
		            mapType: '上海',
		            itemStyle:{
		                normal:{label:{show:true}},
		                emphasis:{label:{show:true}}
		            },
		           
		        }
		    ]
		};
        // 使用刚指定的配置项和数据显示图表。
        //myChart.setOption(option);
</script>
</body>
</html>