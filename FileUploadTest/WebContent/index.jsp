<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/test/parampost.action" method="post">
		username:<input type="text" name="person.username"/><br>
		id:	<input type="text" name="person.id"/><br>
		<input type="submit" value="提交"/>	
	</form>
	
</body>
</html>