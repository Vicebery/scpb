<%@ page language="java" contentType="text/html; s"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
        <p>链票信息如下：</p>
        <p>链票ID: ${chainTicket.id}</p>
       <p> 链票金额：${chainTicket.amount}</p>
        <p>开具时间：${chainTicket.drawTime}</p>
       <p>开票企业：${chainTicket.drawEnterprise}</p>
        <p>到期日：${chainTicket.deadline}</p>
     </div>
    </body>
</html>
