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
    <style>
       p{font-size:1.4em;text-align:center;}
       input{
       margin-top:3px;
       width:160px;
       height:25px;
       border:2px solid black;
       border-radius:5px;}
    </style>
</head>

<body>
    <form action="<%=request.getContextPath()%>/supplier/financing" method="get">
        <%--链票ID：<input type="text" name="ctid"/><br>--%>
      <p>融资金额：<input type="text" name="amount"/></p><span style="color:red;font-size:16px;">${msg}</span>
      <p>融资企业：<input type="text" name="factor"/></p>
      <p>申请备注：<input type="text" name="tradeRemark"/></p>
      <p><input type="submit" value="确认融资" /></p>
    </form>
</body>
</html>
