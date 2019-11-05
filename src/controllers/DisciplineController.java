package controllers;

import models.AttendanceList;
import models.Discipline;
import models.DisciplineClass;
import models.Student;

public class DisciplineController {
	private Discipline discipline = new Discipline();

	public DisciplineController() {

	}

	public DisciplineController(Discipline discipline) {
		this.discipline = discipline;
	}

	public String getDisciplineName() {
		return this.discipline.getName();
	}
	
	public void addDisciplineClass(DisciplineClass disciplineClass) {
		discipline.addNewClass(disciplineClass);
	}

	public void addStudent(Student student) {
		discipline.getDisciplineClassList().getLast().getStudentList().put(student.getName(), student);
	}

	public boolean addAttendence(AttendanceList attendanceList) {
		return discipline.getDisciplineClassList().getLast().getAttendanceList().add(attendanceList);
	}

	public void markPresence(Student student) throws IllegalArgumentException {
		String name = student.getName();
		if (discipline.getDisciplineClassList().getLast().getStudentList().containsKey(name)) {
			AttendanceList attendanceList = discipline.getDisciplineClassList().getLast().getAttendanceList().getLast();
			attendanceList.getStudentListKey().add(name);
		} else {
			throw new IllegalArgumentException("Estudante não encontrando na lista, presença não confirmada");
		}
	}
}
