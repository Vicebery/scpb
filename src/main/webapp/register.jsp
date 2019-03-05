<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/registerFin" method="get">
        企业编号：<input type="text" name="id"/><br>
        企业账号：<input type="text" name="account"/><br>
        账号密码：<input type="text" name="pwd"/><br>
        银行账户：<input type="text" name="bank"/><br>
        企业名字：<input type="text" name="name"/><br>
        统一社会信用代码：<input type="text" name="UCC"/><br>
        法人证件号：<input type="text" name="LPC"/><br>
        企业类型：<input type="text" name="type"/><br>
        <input type="submit" value="用户注册" />
    </form>
</body>
</html>
