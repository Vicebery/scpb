<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接收成功</title>
</head>
    <body>
        链票信息如下：<br/>
        链票ID: ${chainTicket.id}<br/>
        链票金额：${chainTicket.amount}<br/>
        开具时间：${chainTicket.drawTime}<br/>
        开票企业：${chainTicket.drawEnterprise}<br/>
        到期日：${chainTicket.deadline}<br/>
    </body>
</html>
