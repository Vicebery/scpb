<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2019/3/21
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>签收状态</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<style>
	   p{fint-size:1.4em;text-align:center;}
	</style>
</head>
<body>
    
    <p>链票签收成功！</p>
    <p>链票信息如下：<p/>
    <p>链票ID: ${chainTicket.id}</p>
    <P>链票金额：${chainTicket.amount}<p/>
    <p>开具时间：${chainTicket.drawTime}<p/>
    <p>开票企业：${chainTicket.drawEnterprise}<p/>
    <p>到期日：${chainTicket.deadline}<p/>
    <p><input class="btn btn-primary" type="button" value="返回" onclick="window.location.href='receiveCT'" /></p>
</body>
</html>
