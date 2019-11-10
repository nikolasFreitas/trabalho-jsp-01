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
	<h1>Disciplinas que o <%= request.getParameter("studentName") %> cursa</h1>
	<div>
		<p>Selecione a disciplina para ter mais detalhes</p>
		<ul>
			<%
				String studentName = request.getParameter("studentName");
				List<Discipline> disciplineList = courseController.getDisciplineByStudent(studentName);
				if(disciplineList.isEmpty()){
				%>
					<p><a href="StudentList.jsp?studentName=<%=studentName%>">Voltal à página anterior</a></p>
					<p>Este aluno não está matrículado em nenhuma disciplina</p>
				<%
				} else {
					for(Discipline discipline : disciplineList) {
						String qs = "studentName="+studentName+"&discipline="+discipline.getName();
				%>
						<li>
							<a href="DisciplineClass.jsp?<%= qs %>"> 
								<%=discipline.getName()%>
							</a>
						</li>						
					<%}
				}%>
		</ul>
	</div>
</body>
</html>