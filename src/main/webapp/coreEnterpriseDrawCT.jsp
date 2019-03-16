<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>链票开具</title>
</head>
<body>
     <form action="<%=request.getContextPath()%>/coreEnterprise/coreEnterpriseDrawSuccess" method="get">
         开票企业：<input type="text" name="drawEnterprise"/><br>
         申请企业：<input type="text" name="applicant"/><br>
         链票金额：<input type="text" name="amount"/><br>
         到期日：<input type="text" name="deadline"/><br>

         <input type="submit" value="确认开具" />
     </form>
</body>
</html>