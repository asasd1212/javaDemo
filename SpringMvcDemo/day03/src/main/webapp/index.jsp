<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>index</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<
<button onclick="fun1();">发送json字符串</button>
<button onclick="fun2();">接收json字符串</button>
</body>

<script>
    function fun1(){
        $.ajax({
            url: '${pageContext.request.contextPath}/ajaxRequest',
            data: '{"username":"张三","age":20}',
            type: 'POST',
            contentType: 'application/json;charset=utf-8',
            success: function (data){
                console.log(data)
            }
        })
    }

    function fun2(){
        $.ajax({
            url: '${pageContext.request.contextPath}/ajaxRequest2',
            data: '{"username":"张三","age":20}',
            type: 'POST',
            contentType: 'application/json;charset=utf-8',
            success: function (data){
                console.log(data)
            }
        })
    }
</script>
</html>
