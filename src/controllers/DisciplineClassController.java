package controllers;

import models.AttendanceList;
import models.DisciplineClass;
import models.Student;

public class DisciplineClassController {
	private DisciplineClass disciplineClass = new DisciplineClass();

	public DisciplineClassController() {
	}

	public void addStudent(Student student) {
		disciplineClass.addStudent(student);
	}

	public boolean addAttendence(AttendanceList attendanceList) {
		return disciplineClass.getAttendanceList().add(attendanceList);
	}

	public void markPresence(Student student) throws IllegalArgumentException {
		String name = student.getName();
		if (disciplineClass.getStudentList().containsKey(name)) {
			AttendanceList attendanceList = disciplineClass.getAttendanceList().getLast();
			attendanceList.getStudentListKey().add(name);
		} else {
			throw new IllegalArgumentException("Estudante não encontrando na lista, presença não confirmada");
		}
	}

}
