<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="../js/jquery-3.3.1.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/loadSupplier.js" type="text/javascript"></script>
	<title>链票开具</title>
<style>
form{
    width:60%;
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
     <form action="<%=request.getContextPath()%>/coreEnterprise/drawSuccess" method="get">
         <label>申请企业:</label><select  name="applicant" id="applicant"/></select>
         <br>
         <label>链票金额：</label><input type="text" name="amount"/>
         <span style="color:red;font-size:16px;">${msg}</span><br>
         <label>到期日：</label><input type="text" name="deadline"/><br>
         <label>开具备注：</label><input type="text" name="tradeRemark"/><br>

         <input style="margin-left:66px;margin-top:8px"type="submit" value="确认开具" />
     </form>
</body>
</html>