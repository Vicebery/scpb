<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>用户注册信息</title>
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
            注册信息如下：<br/>
            用户名：${account}<br/>
	用户密码：${pwd}<br/>
           企业银行账户：${bank}<br/>
   	企业名称：${name}<br/>
    UCC：${UCC}<br/>
	LPC：${LPC}<br/>
	企业类型：${type}<br/>
    <a href="login" align ="center">
        <button >前往登陆</button>
    </a>
    </div>


</body>
</html>
