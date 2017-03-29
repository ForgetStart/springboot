<%@ page language="java" contentType="text/html; charset=UTF-8" language="java"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../js/jquery-1.8.3.js"></script>
<title>用户列表</title>
</head>
<body>
	<script type="text/javascript">
		$(function(){
			$("input[name='detail']").unbind('click').bind('click',function(){
				var userId = $(this).parent().parent().find('td:first').attr('id');
				window.location.href = "/user/detail?id="+userId;
			})
		})
	</script>

	<table align="center">
			<tr>
				<td>id</td>
				<td>姓名</td>
			</tr>
		<c:forEach items="${userlist}" var="user">
			<tr>
				<td id="${user.id }"><input type="text" value="${user.id }"/></td>
				<td><input type="text" value="${user.username }"/></td>
				<td><input type="button" value="详细" name="detail"/></td>
				<td><input type="button" value="修改" name="update"/></td>
				<td><input type="button" value="删除" name="delete"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>