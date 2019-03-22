<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2019/3/20
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>链票融资</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/supplier/financing" method="get">
        链票ID：<input type="text" name="ctid"/><br>
        融资金额：<input type="text" name="amount"/><br>
        融资企业：<input type="text" name="factor"/><br>
        持有企业：<input type="text" name="ownerId"/><br>
        申请备注：<input type="text" name="tradeRemark"/><br>
    <input type="submit" value="确认融资" />
</form>
</body>
</html>
