<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>敞口额度</title>
  <style>
  form{
  font-size:2em;
  margin-left:30%;
  }
  </style>
</head>
<body>
 <form action="<%=request.getContextPath()%>/coreEnterprise/queryLimit" method="get">
        敞口额度： ${result}
    </form>
</body>
</html>