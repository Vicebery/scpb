<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script src="../js/jquery-3.3.1.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/loadSupplier.js" type="text/javascript"></script>
    <title>转让界面</title>
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
    <a class="btn btn-primary"  href="chooseTransferCT">返回</a>
    <form action="<%=request.getContextPath()%>/supplier/transferCTSuccess" method="get">
        <p>转让金额：<input type="text" name="amount"/></p>
        <p><span style="color:red;font-size:16px;">${msg}</span></p>
        <p>转让企业：<select  name="applicant" id="applicant"/></select></p>
        <p>申请备注：<input type="text" name="tradeRemark"/></p>
        <p><input type="submit" value="确认转让" /></p>        
    </form>

</body>
</html>
