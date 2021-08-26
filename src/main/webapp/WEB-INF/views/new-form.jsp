<%--
  Created by IntelliJ IDEA.
  User: kimun
  Date: 2021/08/25
  Time: 3:37 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--앞에 슬래쉬('/')를 붙이지 않기 때문에 상대 경로(현재 url의 마지막 경로(new-form)를 버리고 + save)를 사용하게 된다.-->
<form action="save" method="post">
    username: <input type="text" name="username"/>
    age: <input type="text" name="age"/>
    <button type="submit">전송</button>
</form>
</body>
</html>
