<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/param/objectParam">
    姓名：
    <input type="text" name="username" />  <br>
    年龄：
    <input type="text" name="age" >

    <input type="submit" value="提交">
</form>

<form action="${pageContext.request.contextPath}/param/arrayParam">
    <input type="checkbox" name="ids" value="1"> 矢泽优步老湿   <br>
    <input type="checkbox" name="ids" value="2"> 樱井莉亚老湿   <br>
    <input type="checkbox" name="ids" value="3"> 吉泽明步老湿   <br>
    <input type="checkbox" name="ids" value="4"> 泷泽萝拉老湿   <br>
    <input type="checkbox" name="ids" value="5"> 波多野结衣老湿 <br>
    <input type="submit" value="数组类型">
</form>

<form action="${pageContext.request.contextPath}/param/listParam" method="post">
    user属性中的姓名:<input type="text" name="user.username"><br/>
    user属性中的年龄:<input type="text" name="user.age">     <br/>
    map中第一个键值对中的值:<input type="text" name="map['one']"><br/>
    map中第一个键值对中的值:<input type="text" name="map['two']"><br/>
    <input type="checkbox" name="ids" value="1"> 矢泽优步老湿   <br>
    <input type="checkbox" name="ids" value="2"> 樱井莉亚老湿   <br>
    <input type="checkbox" name="ids" value="3"> 吉泽明步老湿   <br>
    <input type="checkbox" name="ids" value="4"> 泷泽萝拉老湿   <br>
    <input type="checkbox" name="ids" value="5"> 波多野结衣老湿 <br>

    <input type="submit" value="复杂类型">
</form>

<form action="${pageContext.request.contextPath}/param/dateParam">
    <input type="text" name="birthday">
    <input type="submit" value="日期提交">
</form>
<form action="${pageContext.request.contextPath}/param/hello?username=张三" method="post">
    <input type="submit">
</form>
</body>
</html>
