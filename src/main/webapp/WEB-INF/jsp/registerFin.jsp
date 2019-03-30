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
    <div>
    <p>企业账号注册成功</p>
    <p>用户信息如下：</p>
    <p>用户ID:${id}</p>
    <p>用户名：${account}</p>
    <p>用户密码：${pwd}</p>
    <p>企业银行账户：${bank}</p>
    <p>企业名称：${name}</p>
    <p>UCC：${UCC}</p>
    <p>LPC：${LPC}</p>
    <p>企业类型：${type}</p>
    </div>
</body>
</html>
