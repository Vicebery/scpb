<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2019/3/9
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>链票接收</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/supplier/supplierReceiveCTSuccess" method="get">
        开票企业：<input type="text" name="drawEnterprise"/><br>
        申请企业：<input type="text" name="applicant"/><br>
        链票ID：<input type="text" name="drawCTId"/><br>
        链票金额：<input type="text" name="amount"/><br>
        开票备注：<input type="text" name="tradeRemark"/><br>

        <input type="submit" value="确认接收" />
    </form>
</body>
</html>
