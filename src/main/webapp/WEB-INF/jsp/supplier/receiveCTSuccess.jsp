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
</head>
<body>
    链票签收成功！<br/>
    链票信息如下：<br/>
    链票ID: ${chainTicket.id}<br/>
    链票金额：${chainTicket.amount}<br/>
    开具时间：${chainTicket.drawTime}<br/>
    开票企业：${chainTicket.drawEnterprise}<br/>
    到期日：${chainTicket.deadline}<br/>
    <input type="button" value="返回" onclick="window.location.href='receiveCT'" />
</body>
</html>
