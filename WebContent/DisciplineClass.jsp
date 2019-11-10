<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="controllers.*"%>
<jsp:useBean id="courseController" class="controllers.CourseController" />
<%
	if (courseController.getCourse() == null) {
%>
	<jsp:include page="RedirectToMain.jsp" />
<%
	}
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
}

h1 {
	text-align: center;
	font-family: sans-serif;
	padding: 15px;
	background: #dedede;
	margin-top: 0px;
}

li {
	padding: 0px 15px;
	color: #050505;
	margin-top: 10px;
}
</style>
<body>
	<%=request.getParameter("studentName")%>
</body>
</html>