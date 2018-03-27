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
			 rownumbers:true,
			 singleSelect:true,
			 fit:true,
			 url:"${pageContext.request.contextPath}/admin/jobLog/listJobLog.do",
			 columns:[[{field:'id',width:50,align:'center',title:'编号'},
			           {field:'jobName',width:150,align:'center',title:'Job名称'},
			           {field:'srcType',width:60,align:'center',title:'分类'},
			           {field:'batchDate',width:100,align:'center',title:'调度日期'},
			           {field:'startTime',width:150,align:'center',title:'开始时间'},
			           {field:'endTime',width:150,align:'center',title:'结束时间'},
			           {field:'status',width:60,align:'center',title:'Job状态'},
			           {field:'sucessFlag',width:100,align:'center',title:'是否成功',formatter: function(value,row,index){
			        	   if(value == 'failure'){
			        		   return '<font color=red>'+value+'</font>';
								
							}else{
								
								return '<font>'+value+'</font>';
							}
							
			        	   
			           }},
			           {field:'errLink',width:100,align:'center',title:'日志查询',formatter: function(value,row,index){return "<a href=\"javascript:searchLog('"+value+"');\">查看</a>";}}
			           ]]
		 });
		 
		
	});

</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="Job配置管理"  toolbar="#tb"></table>
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