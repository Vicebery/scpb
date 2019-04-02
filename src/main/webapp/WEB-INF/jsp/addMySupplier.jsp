<%--
  Created by IntelliJ IDEA.
  User: 15071
  Date: 2019/3/30
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加供应商</title>
    <style>
    p{
    
	font-size:1.2em;
	margin:0 auto;
    }
    label{
    display:inline-block;
    margin-top:3px;
	width:128px;
	margin-right:5px;
	text-align:right;
    }
    input{
    margin-top:3px;
    width:160px;
    height:25px;
    border:2px solid black;
    border-radius:5px;
}
    </style>
</head>
<body>
    <form action="<%=request.getContextPath()%>/addMySupplier" method="get">
        <p><label>供应商名字：</label><input type="text" name="name"/></p>
        <p><label>供应商账号：</label><input type="text" name="account"/></p>
        <input style="margin-left:66px;margin-top:8px"type="submit" value="确认添加" />
    </form>
</body>
</html>
