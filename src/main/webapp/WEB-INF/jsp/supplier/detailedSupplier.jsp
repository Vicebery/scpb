<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>供应商详情</title>
</head>
<body>
    该供应商信息如下：<br/>
    供应商名字: ${supplier.name}<br/>
    供应商账号：${supplier.account}<br/>
    供应商银行账户：${supplier.bank}<br/>
    统一社会信用代码：${supplier.UCC}<br/>
    法人证件号：${supplier.LPC}<br/>
    <br/>
    <input type="button" value="返回" onclick="window.location.href='mySupplier'" />
    <input type="button" value="删除该供应商" onclick="window.location.href='deleteSupplier'" />
</body>
</html>
