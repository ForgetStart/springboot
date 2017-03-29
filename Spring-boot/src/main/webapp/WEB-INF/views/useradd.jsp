<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		$(function(){
			$('#look').unbind('click').bind('click',function(){
				window.location.href = "/user/list";
			});
		})
	</script>
	<form action="/user/save" method="post">
		<table align="center">
			<tr>
				<td>用户名:<input type="text" name="username"/></td>
				<td>密码:<input type="text" name="password"/></td>
			</tr>
			<tr >
				<td align="center"><input type="submit" value="提交"/></td>
				<td align="center"><input type="button" value="查看列表" id="look"/></td>
			</tr>
		</table>
	</form>
</body>
</html>