<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <form action="/login" method="post">
            <div><label> 用户名 : <input type="text" name="username"/> </label></div>
            <div><label> 密码: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="登录"/></div>
        </form>
</body>
</html>