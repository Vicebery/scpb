<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>我的供应商</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
    我的供应商列表：
    <table width="100%" class="table table-bordered table-hover">
        <tr>
            <td>供应商名字</td>
            <td>供应商账号</td>
            <td></td>
        </tr>
        <c:forEach items="${suppliers }" var="supplier">
            <tr>
                <td>${supplier.name }</td>
                <td>${supplier.account }</td>
                <td> <a href="detailedSupplier?account=${supplier.account}">了解详情</a></td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" style="margin:0 auto"class="btn btn-primary" value="新增供应商" onclick="window.location.href='goaddSupplier'" />
</body>
</html>
