<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.4/css/bootstrap.css"
	rel="stylesheet">
	</head>
	<body>
		<table border="1">
			<tr>
				<td>用户ID</td>
				<td>用户名</td>
			</tr>
			<#list userList as user>
			<tr>
				<td>${user.userName}</td>
				<td>${user.userId}</td>
			</tr>
			</#list>
		</table>
	</body>
</html>  