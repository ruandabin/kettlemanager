<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="header.jsp" %>
<script type="text/javascript">

	var url;
	
	function searchJobMap(){
		$("#dg").datagrid('load',{
			"jobName":$("#s_jobName").val()
		});
	}
	
	function deleteJobMap(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/admin/jobMap/deleteJobMap.do",{ids:ids},function(result){
					if(result.success ==  "true"){
						$.messager.alert("系统提示","数据已成功删除！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败！");
					}
				},"json");
			}
		});
		
	}
	
	
	function openJobAddDialog(){
		resetValue();
		$("#dlg").dialog("open").dialog("setTitle","添加Job配置信息");
		url="${pageContext.request.contextPath}/admin/jobMap/saveJobMap.do";
	}
	
	
	function saveJob(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success ==  "true"){
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","保存失败");
					return;
				}
			}
		});
	}
	
	function openJobModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑用户信息");
		$('#fm').form('load',row);
		url="${pageContext.request.contextPath}/admin/jobMap/updateJobMap.do?id="+row.id;
	}
	
	function resetValue(){
		$("#jobName").val("");
		$("#srcType").val("");
		$("#dataFile").val("");
		$("#runTime").val("");
		$("#preProcs").val("");
		$("#isTrue").val("");
		$("#remark").val("");
	}
	
	function closeJobDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
</script>
</head>
<body style="margin:1px;">
	<table id="dg" title="Job配置管理" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="${pageContext.request.contextPath}/admin/jobMap/listJobMap.do" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="30" align="center">编号</th>
	 		<th field="jobName" width="300" align="center">Job名称</th>
	 		<th field="srcType" width="100" align="center">分类</th>
	 		<th field="dataFile" width="300" align="center">加载文件名</th>
	 		<th field="runTime" width="80" align="center">调度时间</th>
	 		<th field="preProcs" width="80" align="center">前向依赖</th>
	 		<th field="isTrue" width="80" align="center">是否启用</th>
	 		<th field="remark" width="100" align="center">job说明</th>
	 	</tr>
	 </thead>
	</table>
	<div id="tb">
		<div>
			<a href="javascript:openJobAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openJobModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteJobMap()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;Job名称：&nbsp;<input type="text" id="s_jobName" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
			<a href="javascript:searchJobMap()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" modal="true" style="width: 1000px;height:350px;padding: 10px 20px"
	  closed="true" buttons="#dlg-buttons">
	 	<form id="fm" method="post">
	 		<table cellspacing="10px"  border="0">
	 			<tr>
	 				<td>Job名称：</td>
	 				<td><input type="text" id="jobName" name="jobName" style="width:300px;" class="easyui-validatebox" required="true" />&nbsp;<font color="red">*</font></td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>分类：</td>
	 				<td><input type="text" id="srcType" name="srcType" style="width:300px;" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 			</tr>
	 			<tr>
	 				<td>加载文件名：</td>
	 				<td><input type="text" id="dataFile" name="dataFile" style="width:300px;" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>调度时间：</td>
	 				<td><input type="text" id="runTime" name="runTime" style="width:300px;" class="easyui-validatebox"  required="true"/>&nbsp;<font color="red">*</font></td>
	 			</tr>
	 			<tr>
	 				<td>是否启用：</td>
	 				<td><input type="text" id="isTrue" name="isTrue" style="width:300px;" class="easyui-validatebox" required="true"/>&nbsp;<font color="red">*</font></td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>job说明：</td>
	 				<td><input type="text" id="remark" name="remark" style="width:300px;" class="easyui-validatebox"  required="true"/>&nbsp;<font color="red">*</font></td>
	 			</tr>
	 			<tr>
	 				<td>前向依赖：</td>
	 				<td><input type="text" id="preProcs" name="preProcs" style="width:300px;" class="easyui-validatebox" required="true"/>&nbsp;<font color="red"></font></td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 			</tr>
	 			
	 		</table>
	 	</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveJob()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeJobDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>