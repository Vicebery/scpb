<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>链票信息列表</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
		链票列表：
		<table width="100%" class="table table-bordered table-hover">
		<thead><tr>
			<td>链票ID</td>
			<td>金额</td>
			<td>生成时间</td>
			<td>开票企业</td>
			<td>过期时间</td>
			<td>链票状态</td>
		</tr><thead>
		<c:forEach items="${chainTicketList }" var="chainTicket">
		<tbody><tr>
			<td>${chainTicket.id }</td>
			<td>${chainTicket.amount }</td>
			<td>${chainTicket.drawTime}</td>
			<td>${chainTicket.drawEnterprise }</td>
			<td>${chainTicket.deadline }</td>
			<td>${chainTicket.state }</td>
			<%--<td> <a href="findCTonChain?id=${chainTicket.id}&drawEnterprise=${chainTicket.drawEnterprise}
				&state=${chainTicket.state}">查看链上信息</a></td>--%>
		</tr></tbody>
		</c:forEach>
		
		</table>
		<script type="text/javascript" src="js/changeState.js"></script>
</body>
</html>
<!-- <td><fmt:formatDate value="${chainTicket.drawTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>  -->