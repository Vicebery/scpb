<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主页</title>
</head>
<body>
	您好！ ${id}，欢迎登陆<br/>

    <div>
		<a target="aaa" href="managerInfo">企业信息管理</a>
		<a target="aaa" href="chainTickets">链票查询</a>
		<a target="aaa" href="drawCT">开具链票</a>
        <a target="aaa" href="fail">失败页面测试</a>
    </div>
    <iframe name="aaa" width="100%" src="managerInfo">
    </iframe>
</body>
</html>
