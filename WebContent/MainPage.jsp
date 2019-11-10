<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="main.Start"%>
<jsp:useBean id="startPage" class="main.Start" scope="request" />
<%
	startPage.mockInfos();
	startPage.verifyCourse();
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
		margin-top: 0px;
	}
	
	h1 {
		text-align: center;
		font-family: sans-serif;
		padding: 15px;
		background: #dedede;
		margin-top: 0px;
	}
	
	div {
		padding: 0px 15px;	
	}
	
	p {
		color: #050505;
	}
</style>
	<% 
		String isRedirected = request.getParameter("isRedirected");
	%>
<body>
	<h1>Bem-vindo a aplicação que será o futuro do IFRS</h1>
	<div>
		<%
			if(isRedirected != null)
			%> <p>É obrigatório passar por esta página antes de iniciar o sistema pela primeira vez</p> <%
		%>
		<a href="StudentList.jsp">Ir para próxima página</a>	
	</div>
</body>
</html>