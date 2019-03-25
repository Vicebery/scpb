<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>企业信息修改</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<style>
form{
    width:60%;
	font-size:1.2em;
	margin:0 auto;
}
label{
display:inline-block;
	width:128px;
	margin-right:5px;
	text-align:right;
}
input{
width:160px;
height:26px;
border:2px solid black;
border-radius:5px;
}
</style>
</head>
<body>
<font color="red">${requestScope.message }</font>
	<form action="<%=request.getContextPath()%>/execModifyInfo" method="get">
	
		<p><label>企业Id:</label><input type="text" name="id" value="${enterprise.id}" readonly="true"/></p>
		<p><label>企业账户:</label> <input type="text" name="account" value="${enterprise.account}"/></p>
		<p><label>企业银行账户:</label> <input type="text" name="bank" value="${enterprise.bank}"/></p>
		<p><label>企业名称:</label> <input type="text" name="name" value="${enterprise.name}"/></p>
		<p><label>企业类型:</label> <input type="text" name="type" value="${enterprise.type}"/></p>
		<p><label>UCC:</label> <input type="text" name="UCC" value="${enterprise.UCC}"/></p>
		<p><label>LPC:</label> <input type="text" name="LPC" value="${enterprise.LPC}"/></p>
		<p><label>密码:</label> <input type="text" name="pwd" value="${enterprise.pwd}"/></p>		
		<input style="margin-left:64px" type="submit" value="确认" />
  
	</form>
	
</body>
</html>