<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商首页</title>
</head>
<body>
	供应商登录成功
	<br /> 企业信息如下：
	<br /> 用户ID: ${enterprise.id}
	<br /> 用户名：${enterprise.account}
	<br /> 企业银行账户：${enterprise.bank}
	<br /> 企业名称：${enterprise.name}
	<br /> UCC：${enterprise.UCC}
	<br /> LPC：${enterprise.LPC}
	<br /> 企业类型：${enterprise.type}
	<br />

	<form action="<%=request.getContextPath()%>/transaction/tradeSuccess" method="get">
		        甲方企业：<input type="text" name="firstParty"/><br>
		        乙方企业：<input type="text" name="secondParty"/><br>
		        交易金额：<input type="text" name="sum"/><br>
		        支付链票：<input type="text" name="payCT"/><br>
		        交易备注：<input type="text" name="tradeRemark"/><br>

        <input type="submit" value="确认交易" />
	</form>
</body>
</html>