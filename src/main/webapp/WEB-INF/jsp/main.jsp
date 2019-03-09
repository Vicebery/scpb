<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户个人信息主页</title>
</head>
<body>
	根据ID查询用户信息成功<br/>
	${err}<br/>
	用户信息如下：<br/>
	用户ID:${id}<br/>
	用户名：${account}<br/>
	
	企业银行账户：${bank}<br/>
	企业名称：${name}<br/>
	UCC：${UCC}<br/>
	LPC：${LPC}<br/>
	企业类型：${type}<br/>

</body>
</html>
