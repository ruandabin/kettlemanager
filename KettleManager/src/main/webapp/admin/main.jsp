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
var url;

function openTab(text,url,iconCls){
	if($("#tabs").tabs("exists",text)){
		$("#tabs").tabs("select",text);
	}else{
		var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
		$("#tabs").tabs("add",{
			title:text,
			iconCls:iconCls,
			closable:true,
			content:content
		});
	}
}

function logout(){
	$.messager.confirm("系统提示","您确定要退出系统吗",function(r){
		if(r){
			window.location.href="${pageContext.request.contextPath}/user/logout.do";
		}
	});
}

function openPasswordModifyDialog(){
	$("#dlg").dialog("open").dialog("setTitle","修改密码");
	url="${pageContext.request.contextPath}/user/modifyPassword.do?id=${currentUser.id}";
}
function closePasswordModifyDialog(){
	$("#dlg").dialog("close");
	$("#newPassword").val("");
	$("#newPassword2").val("");
}
function modifyPassword(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			var newPassword=$("#newPassword").val();
			var newPassword2=$("#newPassword2").val();
			if(!$(this).form("validate")){
				return false;
			}
			if(newPassword!=newPassword2){
				$.messager.alert("系统提示","两次输入密码不一致！");
				return false;
			}
			return true;
		},
		success:function(result){
			var result=eval('('+result+')');
			if(result.success ==  "true"){
					$.messager.alert("系统提示","密码修改成功，下一次登录生效！！");
					closePasswordModifyDialog();
				}else{
					$.messager.alert("系统提示","密码修改失败！");
					return;
				}
		}
	});
}


</script>
<style type="text/css">
#result{
 margin:1px 1px;
 font-size:15px;
 color:#FF0000;
 padding:10px;
}
</style>
</head>
<body class="easyui-layout" onload="showTime()">
<div class="rdb" region="north" style="height: 85px ">
	<table style="padding: 5px" width="100%">
		<tr>
			<td width="50%">
				<!-- <div class="knockout"><a>ETL监控分析系统</a></div> -->
			</td>
			<td valign="bottom" align="right" width="50%">
				<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentUser.nickName}</font>【${currentUser.roleName }】
				<div id="result"></div>
			</td>
		</tr>
	</table>
</div>
<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs">
		<div  title="首页" data-options="iconCls:'icon-home'">
		   <!--  <div style=" margin-top:20px;margin-left:60px"><font color="BLUE" size="5">上海市地图</font></div>  -->
			<div id="main_charts" style="width: 1000px;height:500px;">
			</div> 
		</div>
	</div>
</div>
<div region="west" style="width: 200px" title="导航菜单" split="true">
	<div class="easyui-accordion" data-options="fit:true,border:false">
		<div title="Job调度情况管理" data-options="selected:true,iconCls:'icon-yxgl'" style="padding: 10px">
			<a href="javascript:openTab('最近调度情况查询','JobLog.jsp','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">最近调度情况查询</a>
			<a href="javascript:openTab('历史调度情况查询','JobHisLog.jsp','icon-khkfjh')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khkfjh'" style="width: 150px;">历史调度情况查询</a>
		</div>
		<div title="ords接口调度情况查询" data-options="selected:true,iconCls:'icon-yxgl'" style="padding: 10px">
			<a href="javascript:openTab('接口调用情况查询','IntLog.jsp','icon-yxjhgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-yxjhgl'" style="width: 150px;">ords接口调度情况查询</a>
		</div>
		
		<div title="Job配置管理"  data-options="iconCls:'icon-khgl'" style="padding:10px;">
			<a href="javascript:openTab('Job配置管理','JobManage.jsp','icon-khxxgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khxxgl'" style="width: 150px;">Job配置管理</a>
		</div>
		<div title="文件下载管理" data-options="iconCls:'icon-fwgl'" style="padding:10px">
			<a href="javascript:openTab('日志文件','LogFile.jsp','icon-fwcj')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-fwcj'" style="width: 150px;">日志文件</a>
			<a href="javascript:openTab('数据文件','DataFile.jsp','icon-fwfp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-fwfp'" style="width: 150px;">数据文件</a>
		</div>
		<div title="统计报表"  data-options="iconCls:'icon-tjbb'" style="padding:10px">
			<a href="javascript:openTab('job调度分析','job_analysis.jsp','icon-khgxfx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khgxfx'" style="width: 150px;">job调度分析</a>
			<!-- <a href="javascript:openTab('job数量统计','num_analysis.jsp','icon-khgcfx')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-khgcfx'" style="width: 150px;">job数量统计</a> -->
		</div>
		<div title="系统管理"  data-options="iconCls:'icon-item'" style="padding:10px">
			<a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
			<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
		</div>
	</div>
</div>
<div region="south" style="height: 25px;padding: 5px;" align="center">
	浙江鸿程
</div>
	<div>
	<div id="dlg" class="easyui-dialog" style="width: 400px;height:250px;padding: 10px 20px"
	closed="true" buttons="#dlg-buttons">
	<form id="fm" method="post">
		<table cellspacing="8px">
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="userName" name="userName" value="${currentUser.userName }" readonly="readonly" style="width: 200px"/></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="password" id="newPassword" name="password" class="easyui-validatebox" required="true" style="width: 200px"/></td>
			</tr>
			<tr>
				<td>确认新密码：</td>
				<td><input type="password" id="newPassword2"   class="easyui-validatebox" required="true" style="width: 200px"/></td>
	 			</tr>
	 		</table>
	 	</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</div>



<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main_charts'));
	option = {
			title : {
		        text:'上海市地图',
		        x:'center',
		        y:'top',
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
        myChart.setOption(option);
        
function showTime(){
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