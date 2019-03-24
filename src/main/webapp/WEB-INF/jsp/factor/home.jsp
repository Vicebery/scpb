<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>保理商主界面</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="js/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/baolishang.css">
		<script src="js/jquery-3.3.1.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="header">
				<p>当前用户：<span>${id}</span></p>
			</div>
			<div class="content">
				<div class="row">
					<div class="col-sm-3 col-md-3 left-part">
						<ul>
							<li data-toggle="collapse" data-target="#ex1"><a>链票业务</a>
								<ul id="ex1" class="collapse">
									<li id="limitset"><a>额度设置</a></li>
									<li id="ctcollect"><a>链票催收</a></li>
									<li id="ctquery"><a>链票查询</a></li>
								</ul>
							</li>
							<li data-toggle="collapse" data-target="#ex2"><a>审查业务</a>
								<ul id="ex2" class="collapse">
									<li id="ctSecondExam"><a>开具复审</a></li>
									<%--<li id="financeExam"><a>融资初审</a></li>--%>
									<li id="financeExam"><a target="financeExam-showcontent" href="factor/financingExamine">融资审核</a></li>
								</ul>
							</li>

							<li data-toggle="collapse" data-target="#ex3"><a>产品管理</a>
								<ul id="ex3" class="collapse">
									<li id="qyInforManage"><a>企业信息管理</a></li>
									<li id="qyUserManage"><a>企业用户管理</a></li>
									<li id="bankManage"><a>银行账户管理</a></li>
									<li id="sureInforManage"><a>认证资料管理</a></li>
									<li id="supply"><a>我的供应商</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="col-sm-9 col-md-9 right-part">

						<div id="limitset-page" style="display:none">
							<p>额度设置:</p>
							<div id="limitset-showcontent"></div>
						</div>

						<div id="ctcollect-page" style="display:none">
							<p>链票催收:</p>
							<div id="ctcollect-showcontent"></div>
						</div>

						<div id="ctquery-page" style="display:none">
							<p>链票查询:</p>
							<div id="ctquery-showcontent"></div>
						</div>

						<div id="ctSecondExam-page" style="display:none">
							<p>开具复审:</p>
							<div id="ctSecondExam-showcontent"></div>
						</div>

						<%--<div id="financeExam-page" style="display:none">
							<p>融资初审:</p>
							<div id="financeExam-showcontent"></div>
						</div>--%>

						<div id="financeExam-page" style="display:none">
							<p>融资审核:</p>
							<div id="financeExam-showcontent">
								<iframe name="financeExam-showcontent" width="100%">
								</iframe>
							</div>
						</div>

						<div id="qyInforManage-page" style="display:none">
							<p>企业信息管理:</p>
							<div id="qyInforManage-showcontent"></div>
						</div>

						<div id="qyUserManage-page" style="display:none">
							<p>企业用户管理:</p>
							<div id="qyUserManage-showcontent"></div>
						</div>

						<div id="bankManage-page" style="display:none">
							<p>银行账户管理:</p>
							<div id="bankManage-showcontent"></div>
						</div>

						<div id="sureInforManage-page" style="display:none">
							<p>认证资料管理:</p>
							<div id="sureInforManage-showcontent"></div>
						</div>

						<div id="supply-page" style="display:none">
							<p>我的供应商:</p>
							<div id="supply-showcontent"></div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<script src="js/baolishang.js"></script>
	</body>
</html>
