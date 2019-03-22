<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="js/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/heixin.css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>供应商主界面</title>
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
							<li data-toggle="collapse" data-target="#ex2"><a>我的链票</a>
								<ul id="ex2" class="collapse">
									<li id="ctfinance"><a>链票融资</a></li>
									<%--<li id="ctsign"><a>链票签收</a></li>--%>
									<li id="ctsign"><a target="ctsign-showcontent" href="supplier/receiveCT">链票签收</a></li>
									<li id="cttransfer"><a>链票转让</a></li>
									<li id="ctquery"><a>链票查询</a></li>
								</ul>
							</li>


							<li data-toggle="collapse" data-target="#ex4"><a>产品管理</a>
								<ul id="ex4" class="collapse">
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

						<div id="ctfinance-page" style="display:none">
							<p>链票融资:</p>
							<div id="ctfinance-showcontent">
								<form action="<%=request.getContextPath()%>/supplier/financing" method="get">
									链票ID：<input type="text" name="ctid"/><br>
									融资金额：<input type="text" name="amount"/><br>
									融资企业：<input type="text" name="factor"/><br>
									持有企业：<input type="text" name="ownerId"/><br>
									申请备注：<input type="text" name="tradeRemark"/><br>
									<input type="submit" value="确认融资" />
                                </form>
							</div>
						</div>

						<div id="ctsign-page" style="display:none">
							<p>链票签收:</p>
							<div id="ctsign-showcontent">
								<iframe name="ctsign-showcontent" width="100%">
								</iframe>
							</div>
						</div>

						<div id="cttransfer-page" style="display:none">
							<p>链票融资:</p>
							<div id="cttransfer-showcontent">

							</div>
						</div>

						<div id="ctquery-page" style="display:none">
							<p>链票查询:</p>
							<div id="ctquery-showcontent"></div>
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
		<script src="js/gongyingshang.js"></script>
</body>
</html>