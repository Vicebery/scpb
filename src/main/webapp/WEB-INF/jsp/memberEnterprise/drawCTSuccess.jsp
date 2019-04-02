<%@ page language="java" contentType="text/html; s"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <title>链票开具成功</title>
    <style>
         div{
             width:50%;
             margin:0 auto;    
         }
         p{
         font-size:1.4em;
         text-align:left;
         }
    </style>
</head>
    <body>
    <div>
    
       <p>开具成功！链票信息如下：</p>
        <p>链票ID: ${chainTicket.id}</p>
        <p>链票金额：${chainTicket.amount}</p>
        <p>开具时间：${chainTicket.drawTime}</p>
        <p>开票企业：${chainTicket.drawEnterprise}</p>
       <p>链票状态：${chainTicketState}</p>
       <p> 到期日：${chainTicket.deadline}</p>
       <p><a class="btn btn-primary "  href="goDrawCT">返回</a></p>
    </div>
    </body>
</html>
