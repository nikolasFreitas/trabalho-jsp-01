package controllers;

import java.util.Set;

import models.AttendanceList;
import models.Course;
import models.Discipline;
import models.DisciplineClass;
import models.Student;

public class CourseController {
	private Course course = new Course();
	
	public CourseController() {
		
	}

	public Set<String> getDisciplineKeys() {
		return course.getDisciplineList().keySet();
	}

	public boolean addDisciplineClass(DisciplineClass disciplineClass, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		return discipline.addNewClass(disciplineClass);
	}

	public void addDiscipline(Discipline discipline) {
		course.addDiscipline(discipline);
	}

	public void addStudent(Student student, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);

		discipline.getDisciplineClassList().getLast().getStudentList().put(student.getName(), student);
	}

	public boolean addAttendence(AttendanceList attendanceList, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		return discipline.getDisciplineClassList().getLast().getAttendanceList().add(attendanceList);
	}

	public boolean markPresence(Student student, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		String name = student.getName();
		if (getStudentFromDisciplineClass(name, disciplineName)) {
			AttendanceList attendanceList = discipline.getDisciplineClassList().getLast().getAttendanceList().getLast();
			try {
				return attendanceList.addStudentKey(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	private Discipline getDiscipline(String disciplineName) throws IllegalArgumentException {
		Discipline discipline = course.getDisciplineList().get(disciplineName);
		if (discipline != null) {
			return discipline;
		}

		throw new IllegalArgumentException("Disciplina \"" + disciplineName + "\" não encontranda");
	}

	private boolean getStudentFromDisciplineClass(String name, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		return discipline.getDisciplineClassList().getLast().getStudentList().containsKey(name);
	}
}
