<%@ page language="java" contentType="text/html; s"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>交易成功</title>
</head>
<body>
    交易信息如下：<br/>
    交易ID: ${tradeInformation.id}<br/>
    交易时间：${tradeInformation.tradeTime}<br/>
    甲方企业：${tradeInformation.firstParty}<br/>
    乙方企业：${tradeInformation.secondParty}<br/>
    交易金额：${tradeInformation.sum}<br/>
    付款链票：${tradeInformation.payCT}<br/>
    收款链票：${tradeInformation.receiveCT}<br/>
    结余链票：${tradeInformation.remainCT}<br/>
    交易备注：${tradeInformation.tradeRemark}<br/>
</body>
</html>
