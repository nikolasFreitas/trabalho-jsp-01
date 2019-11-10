<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String qs = request.getParameter("qs");
	System.out.println("Query string received"+ qs);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	font-family: sans-serif;
}

body {
	margin: 0px;
	background: #ecf0f1;
}

h1 {
	text-align: center;
	font-family: sans-serif;
	padding: 15px;
	background: #e67e22;
	margin-top: 0px;
	color: #ecf0f1;
}

div {
	padding: 0px 15px;
}

li {
	
	color: #050505;
	margin-top: 10px;
}
</style>
<body>
	<div>
		<p><a href="DisciplineClass.jsp?<%=qs%>">Adicionado, página</a></p>
		
	
	</div>
</body>
</html>