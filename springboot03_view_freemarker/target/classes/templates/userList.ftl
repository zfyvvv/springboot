<html>
	<head>
		<title>userList.ftl</title>
		<meta charset="UTF-8"/>
	</head>
	<body>
		<table border="1" align="center" width="50%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>
			<#list userList as user>
				<tr>
				<td>${user.userId }</td>
				<td>${user.userName }</td>
				<td>${user.userAge }</td>
			</tr>
			</#list>
			
		</table>
	</body>
	
</html>