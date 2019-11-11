package controllers;

import models.Course;
import models.Student;
import models.enums.TypeOfUser;

public class StudentController {
	private Student student;

	public StudentController() {

	}

	public StudentController(Student student) {
		this.student = student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getName() {
		return student.getName();
	}

	public void setNome(String nome) {
		student.setName(nome);
	}

	public String geteMail() {
		return student.geteMail();
	}

	public void seteMail(String eMail) {
		student.seteMail(eMail);
	}

	public TypeOfUser getTypeOfUser() {
		return student.getTypeOfUser();
	}

	public void addDisciplineClass(Course course) {
		student.setCourse(course);
	}
}
