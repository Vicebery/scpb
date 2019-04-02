<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2019/3/29
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>供应商详情</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div style="widyh:70%;margin:0 auto;font-size:1.2em">
    该供应商信息如下：<br/>
    供应商名字: ${supplier.name}<br/>
    供应商账号：${supplier.account}<br/>
    供应商银行账户：${supplier.bank}<br/>
    统一社会信用代码：${supplier.UCC}<br/>
    法人证件号：${supplier.LPC}<br/>
    <br/>
    <input class="btn btn-primary "type="button" value="返回" onclick="window.location.href='mySupplier'" />
    <input class="btn btn-primary "type="button" value="删除该供应商" onclick="window.location.href='deleteSupplier'" />
</div>
</body>

</html>
