<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待签收链票列表</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>

<%--<script type="text/javascript">
	function received(obj) {
		var thisTR=obj.parentNode.parentNode;
		var chainTicketId=thisTR.getElementsByTagName('td')[0].innerHTML;
		// alert(chainTicketId);
        $.ajax({
            type:"POST",
            url:"receiveCTSuccess",
            data:{'chainTicketId':chainTicketId},
            success:function(data){
                alert("签收成功");
            }
        });
	}
	function unreceived(obj) {
		var thisTR=obj.parentNode.parentNode;
		var chainTicketId=thisTR.getElementsByTagName('td')[0].innerHTML;
        $.ajax({
            type:"POST",
            url:"receiveCTFail",
            data:{'chainTicketId':chainTicketId},
            success:function(data){
                alert("拒签成功");
            }
        });
	}
</script>--%>
</head>

<body>
待签收链票列表：
	<table width="100%" class="table table-bordered table-hover">
		<tr>
			<td>链票ID</td>
			<td>金额</td>
			<td>生成时间</td>
			<td>开票企业</td>
			<td>过期时间</td>
			<td>链票状态</td>
		</tr>
		<c:forEach items="${chainTicketList }" var="chainTicket">
			<tr>
				<td>${chainTicket.id }</td>
				<td>${chainTicket.amount }</td>
				<td>${chainTicket.drawTime}</td>
				<td>${chainTicket.drawEnterprise }</td>
				<td>${chainTicket.deadline }</td>
				<td>${chainTicket.state }</td>
				<td> <a href="receiveCTSuccess?id=${chainTicket.id}">签收</a></td>
				<td> <a href="receiveCTFail?id=${chainTicket.id}">拒签</a></td>
				<%--<td><input name="received" type="submit" value="签收" onclick="received(this)"></td>
				<td><input name="unreceived" type="submit" value="拒签" onclick="unreceived(this)"></td>--%>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
