package models;

import java.io.Serializable;

import models.enums.TypeOfUser;

public class Student extends User implements Serializable {

	private static final long serialVersionUID = -558468025875192424L;

	private int id;
	private Course course;
	private final TypeOfUser typeOfUser = TypeOfUser.Student;

	public Student() {
		super();
		this.id = super.getId();
	}

	public Student(Course course) {
		super();
		this.course = course;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
