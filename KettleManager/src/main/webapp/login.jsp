<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM ETL调度监控系统</title>
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript">
		
		if (window != top)   
	 top.location.href = location.href;   
		
			function login(){
				var userName=$("#userName").val();
				var password=$("#password").val();
				if(userName==null||userName==""){
					alert("用户名不能为空！");
					return;
				}
				if(password==null||password==""){
					alert("密码不能为空！");
					return;
				}
				$("#login").submit();
				
			}
			
			function getWindow(){
	              var c = this.window;    
	              while(c!= c.parent){    
	                c = c.parent;    
	                }    
	          return c; 
	          }	
			
		
</script>
</head>
<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">ZJHC</span>
									<span class="white">Application</span>
								</h1>
								<h4 class="blue">&copy; 浙江鸿程</h4>
								
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												CRM ETL调度监控系统
											</h4>

											<div class="space-6"></div>

											<form id="login" action="${pageContext.request.contextPath}/user/login.do" method="post" >
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="userName" type="text" name="userName" class="form-control" placeholder="Username" value="${user.userName}" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input  id="password" type="password"  name="password" class="form-control" placeholder="Password"  value="${user.password}"/>
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<span><font color="red" id="error">${errorInfo }</font></span>
														<button  type="button" class="width-35 pull-center btn btn-sm btn-primary" onclick="javascript:login();return false;">
															<i class="icon-key"></i>
															Login
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											
											
										</div><!-- /widget-main -->

										
									</div><!-- /widget-body -->
								</div><!-- /login-box -->


							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->
		<script type="text/javascript">
			
		</script>
</body>
</html>
