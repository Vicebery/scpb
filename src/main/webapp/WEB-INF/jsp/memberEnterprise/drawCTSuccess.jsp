<%@ page language="java" contentType="text/html; s"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>链票开具成功</title>
</head>
    <body>
        链票信息如下：<br/>
        链票ID: ${chainTicket.id}<br/>
        链票金额：${chainTicket.amount}<br/>
        开具时间：${chainTicket.drawTime}<br/>
        开票企业：${chainTicket.drawEnterprise}<br/>
       链票状态：${chainTicket.state}<br/>
        到期日：${chainTicket.deadline}<br/>
    </body>
</html>
