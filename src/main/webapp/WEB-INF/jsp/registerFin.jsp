<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>用户注册信息</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style>
     div{
     width:50%;
     margin:0 auto;
     }
     p{
       font-size:1.4em;
     }
    </style>

</head>
 
<body>
 <h1 align = "center">尊敬的${account}，您已注册成功，请前往登陆</h1>
    <div style="text-align:center">
    <p>注册信息如下：</p>
    <p>用户名：${account}</p>
    <p>用户密码：${pwd}</p>
    <p>企业银行账户：${bank}</p>
   	<p>企业名称：${name}</p>
    <p>UCC：${UCC}</p>
	<p>LPC：${LPC}</p>
	<p>企业类型：${type}</p>
    <a href="login" align ="center">
        <button class="btn btn-primary">前往登陆</button>
    </a>
    </div>


</body>
</html>
