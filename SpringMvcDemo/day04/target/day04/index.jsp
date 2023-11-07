<%--
  Created by IntelliJ IDEA.
  User: YL
  Date: 2023/10/30
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload" method="post"  enctype="multipart/form-data">
    用户:<input type="text" name="username"> <br />
    请选择要上传的文件：<input type="file" name="file"/><br />
    <input type="submit" value="上传">
  </form>
  
  <form action="${pageContext.request.contextPath}/test" method="post">
    <input type="text" name="username">
    <input type="submit">
  </form>
  </body>

<script>
</script>
</html>
