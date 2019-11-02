package models;

import models.enums.TypeOfUser;

public class Student extends User {
	private Course course;
	private final TypeOfUser typeOfUser = TypeOfUser.Student;

	public Student() {
	}

	public Student(Course course) {
		super();
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public TypeOfUser getTypeOfUser() {
		return typeOfUser;
	}

}
