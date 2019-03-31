<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加供应商</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/coreEnterprise/addMySupplier" method="get">
        供应商名字：<input type="text" name="name"/><br>
        供应商账号：<input type="text" name="account"/><br>
        <input type="submit" value="确认添加" />
    </form>
</body>
</html>
