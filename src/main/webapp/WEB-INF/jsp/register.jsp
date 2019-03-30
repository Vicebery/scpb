<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>注册界面</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="js/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/register.css">
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
<body>
    <div class="container">
        <div class="header">
        </div>
        <div class="content">
            <div class="title-line"><span>注册</span></div>
            <div>
                <form action="<%=request.getContextPath()%>/registerFin" method="post">
                    <div >
                        <label for="qiyeNumber">企业编号:</label><input type="text" id="id" name="id">
                    </div>
                    <div>
                        <label for="account">企业账号：</label><input type="text" id="account" name="account">
                    </div>
                    <div>
                        <label for="pwd">账号密码：</label><input type="text" id="pwd" name="pwd">
                    </div>
                    <div>
                        <label for="bank">银行账户：</label><input type="text" id="bank" name="bank">
                    </div>
                     <div>
                        <label for="qiyeName">企业名字：</label><input type="text" id="name" name="name">
                    </div>
                    <div>
                        <label for="UCC">统一社会信用代码：</label><input type="text" id="UCC" name="UCC">
                    </div>
                    <div>
                        <label for="LPC">法人证件号：</label><input type="text" id="LPC" name="LPC">
                    </div>
                    <div>
                        <label for="qiyeType">企业类型：</label>
                        <select name="type">
                        <option value="1">核心企业</option>
                        <option value="2">成员企业</option>
                        <option value="3">供应商</option>
                        <option value="4">保理商</option>
                        </select>
                        
                    </div>
                    <input type="submit" value="用户注册" id="register">
                    
                </form>
            </div>          
        </div>
    </div>
</body>
</html>
