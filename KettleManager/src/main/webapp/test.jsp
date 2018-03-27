<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/rdb.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/china.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dark.js"></script>
<style type="text/css">
#result{
 width:500px;
 border:1px solid #CCCCCC;
 background:#FFFFCC;
 margin:50px auto;
 font-size:24px;
 color:#FF0000;
 padding:20px;
}
</style>
</head>
<body style="margin:1px;" onload="showTime()">
<div id="result"></div>
<script type="text/javascript">
function showTime()
{
 //创建Date对象
 var today = new Date();
 //分别取出年、月、日、时、分、秒
 var year = today.getFullYear();
 var month = today.getMonth()+1;
 var day = today.getDate();
 var hours = today.getHours();
 var minutes = today.getMinutes();
 var seconds = today.getSeconds();
 //如果是单个数，则前面补0
 month  = month<10  ? "0"+month : month;
 day  = day <10  ? "0"+day : day;
 hours  = hours<10  ? "0"+hours : hours;
 minutes = minutes<10 ? "0"+minutes : minutes;
 seconds = seconds<10 ? "0"+seconds : seconds;
  
 //构建要输出的字符串
 var str = year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds;
  
 //获取id=result的对象
 var obj = document.getElementById("result");
 //将str的内容写入到id=result的<div>中去
 obj.innerHTML = str;
 //延时器
 window.setTimeout("showTime()",1000);
}
</script>
</body>
</html>