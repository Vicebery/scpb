<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业信息管理</title>
</head>
<body>
	当前用户信息如下：<br/>
	用户ID: ${enterprise.id}<br/>
	用户名：${enterprise.account}<br/>
	企业银行账户：${enterprise.bank}<br/>
	企业名称：${enterprise.name}<br/>
	UCC：${enterprise.UCC}<br/>
	LPC：${enterprise.LPC}<br/>
	企业类型：${enterprise.type}<br/>
</body>
</html>