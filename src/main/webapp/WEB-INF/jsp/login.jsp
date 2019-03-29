<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="js/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<script src="js/jquery-3.3.1.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<title>登录页面</title>
	</head>
<body>
	<div class="container">
			<div class="header"></div>
			<div class="content">
				<div class="title-line"><span>登录</span></div>
				<div class="login-part">
					<form  action="<%=request.getContextPath()%>/userLogin" method="post" id="loginForm">
						<div class="input-div">
							<label for="userName">企业ID:</label><input type="text" id="id" name="id"  placeholder="请输入企业ID">
						</div>
						<div class="input-div">
							<label for="userPassword">密码:</label><input type="password" id="pwd" name="pwd" placeholder="请输入密码">
							<span style="color:red;">${msg}</span>
						</div>
						
						<div class="btn-container">
							<a class="btn btn-reg" href="register">注册</a>
						    <a class="btn btn-login" onclick="document:loginForm.submit()">登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>