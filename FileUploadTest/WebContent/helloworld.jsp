<%@ page language="java" import="java.util.*,java.net.URLDecoder " contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%= URLDecoder.decode(new String(request.getParameter("username").getBytes("ISO8859-1"),"UTF-8"), "UTF-8") %>
</body>
</html>