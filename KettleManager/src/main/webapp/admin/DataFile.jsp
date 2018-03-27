<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="header.jsp" %>
<script type="text/javascript">
$(function(){
	$('#tt').tree({
		url:'${pageContext.request.contextPath}/admin/jobLog/listLogFile.do?path=/home/etluser/etl_data',
		lines:true,
		onContextMenu: function(e, node){
			 e.preventDefault();
			 var children = $('#tree').tree('getChildren', node.target);
			 var state = node.state;
			 //alert(node.id);
			 if(children == '' && state != 'closed'){
                
                 
                 $('#parentNode').menu({
                     onClick:function(item){
                 		if(item.name == 'down_file'){
                 			var str='${pageContext.request.contextPath}/admin/jobLog/downLog.do?path='+node.id;
                 			$('#log_down').attr("href",str);
							$('#log_down')[0].click() ;
                 		}
                 		if(item.name == 'remove_file'){
                 			$.messager.confirm("系统提示","您确认要删除<font color=red>"+node.id+"</font>吗？",function(r){
                 				if(r){
                 					$.post("${pageContext.request.contextPath}/admin/jobLog/deleteFile.do",{path:node.id},function(result){
                 						if(result.success ==  "true"){
                 							$.messager.alert("系统提示","数据已成功删除！");
                 							//$("#dg").datagrid("reload");
                 							$('#tt').tree("reload");
                 						}else{
                 							$.messager.alert("系统提示","数据删除失败！");
                 						}
                 					},"json");
                 				}
                 			});
                 		}
                     }
                 });
                 $('#parentNode').menu('show', {    
                     left: e.pageX,    
                     top: e.pageY    
                 });  
             } 
			
		}
	});
});

//function downNode(){
//	alert('sssssssssss')
//}
//function removeNode(){
//	alert('kkkkkkkkkkkk');
//}
</script>
</head>
<body style="margin:1px;">
<div style=" margin-top:20px;margin-left:60px">
	<ul id="tt"></ul>
</div>
	<div id="parentNode" class="easyui-menu"  style="width: 120px;">  
	    <div data-options="name:'down_file'"  iconcls="icon-cut">下载</div>  
	    <div data-options="name:'remove_file'"  iconcls="icon-remove">删除</div>  
	</div> 
	<a href="#" id="log_down"></a> 

	
</body>
</html>