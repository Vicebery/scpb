<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<style>
	p{
	font-size:1.4em;
	margin-top:2px;
	text-align:center;
	}
	div{
	width:50%;
	margin:0 auto;
	}
	
	
	</style>
<title>额度分配</title>

</head>
<body>
	     <div>
	     <p>额度设置成功</p>						
         <p>企业id:${ memberId}</p>
         <p>当前额度：${limit }</p>
         <p><a class="btn btn-primary btn-lg"  href="goAllocateLimit">返回</a></p>
	     </div>
	     

</body>
</html>