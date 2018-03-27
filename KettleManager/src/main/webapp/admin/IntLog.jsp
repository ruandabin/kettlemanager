<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="header.jsp" %>
<script type="text/javascript">	
	function searchJob(){
		$("#dg").datagrid('load',{
			"jobName":$("#s_jobName").val()
		});
	}
	
	function searchLog(value){
		//alert('${pageContext.request.contextPath}/admin/jobLog/findLog?path='+value+'\'');
		//alert(value);
		$('#dd').dialog({
		    title: '日志详情',
		    width: 800,
		    height: 400,
		    closed: false,
		    cache: false,
		    href: '${pageContext.request.contextPath}/admin/jobLog/findLog.do?path='+value,
		    modal: true,
		    buttons:[{text:'下载',handler:function(){downLog(value);}}]
		});	
	}
	
	function downLog(value){
		var str='${pageContext.request.contextPath}/admin/jobLog/downLog.do?path='+value
		$('#log_down').attr("href",str);
	   // alert($('#log_down').attr('href'));
	  // alert("sss");
		$('#log_down')[0].click() ;
	}
	
	$(function(){
		 $('#dg').datagrid({
			 fitColumns:true,
			 pagination:true,
			 pageSize:15,
			 pageList:[15],
			 rownumbers:true,
			 singleSelect:true,
			 fit:true,
			 url:"${pageContext.request.contextPath}/admin/intLog/listOrdsLogs.do",
			 columns:[[{field:'request_ip',width:35,align:'left',title:'应用IP'},
			           {field:'request_date',width:55,align:'left',title:'调用时间'},
			           {field:'request_way',width:20,align:'center',title:'方式'},
			           {field:'request_url',width:200,align:'left',title:'接口URL'},
			           {field:'response_result',width:30,align:'center',title:'结果'},
			           {field:'response_time',width:30,align:'center',title:'响应时间'},
			           {field:'ords_ip',width:39,align:'center',title:'接口服务器IP'},
			           {field:'url_type',width:50,align:'center',title:'自定义接口分类'}
			           ]]
		 });
		 
		
	});

</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="接口调度日志清单"  toolbar="#tb"></table>
	<div id="tb">
		<div>
			&nbsp;Job名称：&nbsp;<input type="text" id="s_jobName" size="20" onkeydown="if(event.keyCode==13) searchJob()"/>
			<a href="javascript:searchJob()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
			<a href="#" id="log_down"></a>
		</div>
		
	</div>
	<div id="dd"></div>

	
</body>
</html>