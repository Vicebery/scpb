<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
	<script src="../js/jquery-3.3.1.js"></script>
	<script src="../js/bootstrap.min.js"></script>
<title>额度分配</title>
<style>
p {
	font-size: 1.4em;
	text-align: center;
	margin-top: 3px;
}
</style>
</head>
<body>
	<p>额度设置成功</p>
	<p>企业名称:${name}</p>
	<p>额度设置：${limit}</p>
	<P>
		<a class="btn btn-primary" href="goSetLimit">返回</a>
	</P>
</body>
</html>