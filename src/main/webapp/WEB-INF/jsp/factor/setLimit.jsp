<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="../js/jquery-3.3.1.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/loadCE.js" type="text/javascript"></script>
	<title>额度分配</title>
<style>
form{
    width:60%;
	font-size:1.2em;
	margin:0 auto;
}
label{

    display:inline-block;
	width:128px;
	margin-right:5px;
	margin-top:4px;
	text-align:right;
}
select{
       margin-top:3px;
       width:160px;
       height:32px;
       border:2px solid black;
       border-radius:5px;
       }
input{
    width:160px;
    height:26px;
    margin-top:4px;
    border:2px solid black;
    border-radius:5px;
}
</style>
</head>
<body>
 <form action="<%=request.getContextPath()%>/factor/setLimit" method="get">
       <label>选择企业:</label><select  name="applicant" id="applicant"/></select><br>
       <label>额度设置：</label><input type="text" name="limit"/><br>
        <input style="margin-left:66px;margin-top:8px"type="submit" value="确认" />
    </form>
</body>
</html>