<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>链票开具</title>
<link rel="stylesheet" type="text/css" href="../css/page.css">
</head>
<body>
 	<form action="<%=request.getContextPath()%>/memberEnterprise/drawCT" method="get">
	        <label>申请企业:</label><input type="text" name="applicant"/><br>
	        <label>链票金额:</label><input type="text" name="amount"/>
	        <span style="color:red;font-size:16px;">${msg}</span><br>
	        <label>到期日:</label><input type="text" name="deadline"/><br>
	        <label>开具备注</label><input type="text" name="tradeRemark"/><br>

       <input style="margin-left:66px;margin-top:8px" type="submit" value="确认开具" />
    </form>
</body>
</html>