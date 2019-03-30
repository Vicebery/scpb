<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>待审核链票列表</title>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
		待审核链票列表：
		<table style="width:90%" id="mytable" class="table table-bordered table-hover">
		<thead><tr>
			<th>链票ID</th>
			<th>金额</th>
			<th>生成时间</th>
			<th>开票企业</th>
			<th>过期时间</th>
			<th>链票状态</th>
		</tr></thead>
		<c:forEach items="${chainTicketList }" var="chainTicket">
		<tbody><tr>
			<td>${chainTicket.id }</td>
			<td>${chainTicket.amount }</td>
			<td>${chainTicket.drawTime}</td>
			<td>${chainTicket.drawEnterprise }</td>
			<td>${chainTicket.deadline }</td>
			<td>${chainTicket.state }</td>
			<td> <a href="passCheckCT?id=${chainTicket.id}&state=2">审核通过</a></td>
			<td> <a href="passCheckCT?id=${chainTicket.id}&state=1">不予通过</a></td>
		</tr></tbody>
		</c:forEach>
		
		</table>

</body>
</html>