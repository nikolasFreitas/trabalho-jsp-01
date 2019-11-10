<%@page import="org.apache.tomcat.websocket.server.UriTemplate"%>
<%@page import="models.AttendanceList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="models.DisciplineClass"%>
<%@page import="models.Student"%>
<%@page import="models.Discipline"%>
<%@page import="java.util.List"%>
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
	padding: 15px;
}

table {
	margin: 0px auto;
	width: 550px;
	border-collapse: collapse;
}

th {
	background: #2c3e50;
	color: #ecf0f1;
}

.green {
	color: #2ecc71;
}

.red {
	color: #e74c3c;
}



tr:nth-child(even) {
	background: #95a5a6;
}

td {
	padding: 15px;
	color: #050505;
	border: 1px solid grey;
	color: #050505;
}

td:nth-child(even), td:last-child {
	text-align: center;
}

.selected {
	color: #8e44ad;
	cursor: pointer;
}

input {
	visibility: hidden;
	position: absolute;
}
</style>
<body>
	<h1>
		Lista de participantes e chamada da turma do aluno
		<%=request.getParameter("studentName")%>
	</h1>
	<%
		String studentName = request.getParameter("studentName");
		String disciplineName = request.getParameter("discipline");
		String shouldAdd = request.getParameter("create");
		String markPresence = request.getParameter("markPresence");
		String qsToRedirect = "studentName=" + studentName + "&discipline=" + disciplineName;

		DisciplineClass disciplineClass = courseController.getDisciplineClassFromStudent(studentName,
				disciplineName);

		boolean hasAttendanceList = !disciplineClass.getAttendanceList().isEmpty();

		if (!hasAttendanceList) {
	%>
	<jsp:include page="AddNewAttendanceList.jsp" />
	<%
		}

		if (shouldAdd != null) {
			AttendanceList attendanceList = new AttendanceList();
			courseController.addAttendence(attendanceList, disciplineName);
	%>
	<jsp:forward page="RedirectHandler.jsp">
		<jsp:param value="<%=qsToRedirect%>" name="qs" />
	</jsp:forward>
	<%
		}

		if (markPresence != null) {
			courseController.markPresence(studentName, disciplineName);
	%>
	<jsp:forward page="RedirectHandler.jsp">
		<jsp:param value="<%=qsToRedirect%>" name="qs" />
	</jsp:forward>
	<%
		}
	%>
	<div>
		<p>Adicionar uma nova lista de chamada</p>
		<form method="post"
			action="DisciplineClass.jsp?studentName=<%=studentName%>&discipline=<%=disciplineName%>">
			<input name="create" type="text" value="create" /> <label>Adicione
			</label>
			<button type="submit">adicionar</button>
		</form>
	</div>
	<div>

		<table>
			<thead>
				<th>Nome do aluno</th>
				<th>Está resente</th>
				<th>Dar presença</th>
			</thead>
			<tbody>
				<%
					ArrayList<Student> studentList = new ArrayList<>(disciplineClass.getStudentList().values());
					boolean hasPresence = false;

					for (Student student : studentList) {
						if (hasAttendanceList) {
							hasPresence = disciplineClass.getAttendanceList().getLast().getStudentListKey()
									.contains(student.getName());
						}

						String qs = "studentName=" + studentName;
						String studentSelectedCssClass = student.getName().equals(studentName) ? "selected" : "";
						String title = !studentSelectedCssClass.isEmpty() ? "Este é o aluno selecionado" : "";
				%>
				<tr title="<%=title%>">
					<td title="<%=title%>" class="<%=studentSelectedCssClass%>"><%=student.getName()%>
					</td>
					<td class="<%=hasPresence ? "green" : "red"%>"><%=hasPresence ? "sim" : "não"%></td>
					<td>
						<%
							if (student.getName().equals(studentName) && hasAttendanceList && !hasPresence) {
						%>
						<form method="post"
							action="DisciplineClass.jsp?studentName=<%=studentName%>&discipline=<%=disciplineName%>">
							<input name="markPresence" type="text" value="create" />
							<button type="submit">adicionar presença</button>
						</form> <%
 	}
 %>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>