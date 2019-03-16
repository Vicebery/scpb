<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业信息修改</title>
</head>
<body>
<font color="red">${requestScope.message }</font>
	<form action="<%=request.getContextPath()%>/execModifyInfo" method="get">
		<p>企业Id: <input type="text" name="id" value="${enterprise.id}" readonly="true"/></p>
		<p>企业账户: <input type="text" name="account" value="${enterprise.account}"/></p>
		<p>企业银行账户: <input type="text" name="bank" value="${enterprise.bank}"/></p>
		<p>企业名称: <input type="text" name="name" value="${enterprise.name}"/></p>
		<p>企业类型: <input type="text" name="type" value="${enterprise.type}"/></p>
		<p>UCC: <input type="text" name="UCC" value="${enterprise.UCC}"/></p>
		<p>LPC: <input type="text" name="LPC" value="${enterprise.LPC}"/></p>
		<p>密码: <input type="text" name="pwd" value="${enterprise.pwd}"/></p>		
		<input type="submit" value="确认" />
	</form>
</body>
</html>