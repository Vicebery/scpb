<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2019/3/29
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>融资界面</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/supplier/transferCTSuccess" method="get">
        <%--链票ID：<input type="text" name="ctid"/><br>--%>
        转让金额：<input type="text" name="amount"/><br>
        转让企业：<input type="text" name="factor"/><br>
        申请备注：<input type="text" name="tradeRemark"/><br>
        <input type="submit" value="确认转让" />
    </form>
</body>
</html>
