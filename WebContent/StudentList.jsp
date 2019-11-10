<%@page import="java.util.HashSet"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="models.Discipline"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.DisciplineClass"%>
<%@page import="models.Student"%>
<%@ page import="controllers.*"%>
<jsp:useBean id="courseController" class="controllers.CourseController"
	scope="request" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (courseController.getCourse() == null) {
%><jsp:include page="RedirectToMain.jsp" />
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

li {
	padding: 0px 15px;
	color: #050505;
	margin-top: 10px;
}
</style>
<body>
	<h1>Estamos na sessão de estudantes</h1>
	<ul>
	
	<%
			Set<Student> studentList;
				studentList = courseController.getStudentListFromDisciplineClass();
				
				for(Student student : studentList) {
				System.out.println(student.getId());
		%><li>
				<a href="Discipline.jsp?studentName=<%=student.getName()%>">
					<%= student.getName() %>
				</a>
			</li><%
		}
	%>
	</ul>
</body>
</html>