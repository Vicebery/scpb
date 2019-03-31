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
    <form action="<%=request.getContextPath()%>/supplier/transferCTSuccess" method="get">
        <%--链票ID：<input type="text" name="ctid"/><br>--%>
        <p>转让金额：<input type="text" name="amount"/></p>
        <p>转让企业：<input type="text" name="secondParty"/></p>
        <p>申请备注：<input type="text" name="tradeRemark"/></p>
        <p><input type="submit" value="确认转让" /></p>
        
    </form>
</body>
</html>
