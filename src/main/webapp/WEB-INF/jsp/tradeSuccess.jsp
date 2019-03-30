<%@ page language="java" contentType="text/html; s"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>交易成功</title>
    <style>
    div{
     width:50%;
     margin:0 auto;
     }
     p{
       font-size:1.4em;
     }
    </style>
</head>
<body>
<div>
    <p>交易信息如下：<p/>
    <p>交易ID: ${tradeInformation.id}</p>
    <p>交易时间：${tradeInformation.tradeTime}</p>
    <p>甲方企业：${tradeInformation.firstParty}</p>
    <P>乙方企业：${tradeInformation.secondParty}</p>
    <p>交易金额：${tradeInformation.sum}</p>
    <p>付款链票：${tradeInformation.payCT}</p>
    <p>收款链票：${tradeInformation.receiveCT}</p>
    <p>结余链票：${tradeInformation.remainCT}</p>
    <p>交易备注：${tradeInformation.tradeRemark}</p> </div>
</body>
</html>
