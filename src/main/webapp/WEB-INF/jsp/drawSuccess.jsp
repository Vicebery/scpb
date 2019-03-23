<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>链票开具成功</title>
</head>
<body>
    链票开具成功<br/>
    链票信息如下：<br/>
    链票ID:${id}<br/>
    开具时间：${drawTime}<br/>
    链票金额：${amount}<br/>
    链票状态：${state}<br/>
    开票企业：${drawEnterprise}<br/>
    持有企业：${ownerEnterprise}<br/>
    结算时间：${deadline}<br/>
</body>
</html>