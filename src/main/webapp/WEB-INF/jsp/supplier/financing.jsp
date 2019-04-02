<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>融资界面</title>
    	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <script src="../js/jquery-3.3.1.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/loadFactor.js" type="text/javascript"></script>
    <style>
       p{font-size:1.2em;text-align:center;}
       input{
       margin-top:3px;
       width:160px;
       height:32px;
       border:2px solid black;
       border-radius:5px;}
       select{
       margin-top:3px;
       width:160px;
       height:32px;
       border:2px solid black;
       border-radius:5px;
       }
    </style>
</head>

<body>
<a class="btn btn-primary"  href="#">返回</a>
    <form action="<%=request.getContextPath()%>/supplier/financing" method="get">
        <%--链票ID：<input type="text" name="ctid"/><br>--%>
      <p>融资金额：<input type="text" name="amount"/></p><span style="color:red;font-size:16px;">${msg}</span>
      <p>融资企业：<select  name="factor" id="factor"/></select></p>
      <p>申请备注：<input type="text" name="tradeRemark"/></p>
      <p><input type="submit" value="确认融资" /></p>
    </form>
</body>
</html>
