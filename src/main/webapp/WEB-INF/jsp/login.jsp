<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<font color="red">${requestScope.message }</font>
	<form action="<%=request.getContextPath()%>/main" method="get">
		<p>企业Id: <input type="text" name="id" /></p>
		<p>密码: <input type="text" name="pwd" /></p>
		<input type="submit" value="登录" />
	</form>
</body>
</html>