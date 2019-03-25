<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>链票交易</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/transaction/tradeSuccess" method="get">
        甲方企业：<input type="text" name="firstParty"/><br>
        乙方企业：<input type="text" name="secondParty"/><br>
        交易金额：<input type="text" name="sum"/><br>
        支付链票：<input type="text" name="payCT"/><br>
        交易ID：<input type="text" name="tradeInfId"/><br>

        <input type="submit" value="确认交易" name="verify" />
    </form>
</body>
</html>
