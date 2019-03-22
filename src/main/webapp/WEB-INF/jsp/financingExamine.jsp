<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2019/3/20
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>融资审核</title>
</head>
<body>
融资申请列表：
<table width="100%" border=1>
    <tr>
        <td>链票ID</td>
        <td>金额</td>
        <td>生成时间</td>
        <td>申请企业</td>
        <td>开票企业</td>
        <td>过期时间</td>
        <td>链票状态</td>
    </tr>
    <c:forEach items="${chainTicketList }" var="chainTicket">
        <tr>
            <td>${chainTicket.id }</td>
            <td>${chainTicket.amount }</td>
            <td>${chainTicket.drawTime}"</td>
            <td>${chainTicket.ownerId}</td>
            <td>${chainTicket.drawEnterprise }</td>
            <td>${chainTicket.deadline }</td>
            <td>${chainTicket.state }</td>
            <td><input name="btnyes" type="submit" value="同意融资"></td>
            <td><input name="btnno" type="submit" value="不予融资"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
