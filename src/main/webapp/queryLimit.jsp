<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>额度查询</title>
</head>
<body>
 <form action="<%=request.getContextPath()%>/coreEnterprise/queryLimit" method="get">
        企业id：<input type="text" name="id"/><br>
        <input type="submit" value="确认" />
    </form>
</body>
</html>