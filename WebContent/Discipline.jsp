<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="models.Discipline"%>
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

div {
	padding: 0px 15px;
}

li {
	
	color: #050505;
	margin-top: 10px;
}
</style>
<body>
	<h1>Disciplinas que o estudante cursa</h1>
	<div>
		<p>Selecione a disciplina para ter mais detalhes</p>
		<ul>
			<%
				String studentName = request.getParameter("studentName");
				List<Discipline> disciplineList = courseController.getDisciplineByStudent(studentName);
				
				for(Discipline discipline : disciplineList) {
			%>
			<li>
				<a href="StudentList.jsp?discipline=<%=discipline.getName()%>"> 
					<%=discipline.getName()%>
				</a>
			</li>
			
			<%} %>
		</ul>
	</div>
</body>
</html>