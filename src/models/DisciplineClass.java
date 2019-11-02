package models;

import java.util.*;

public class DisciplineClass {
	private Map<String, Student> studentList = new TreeMap<String, Student>();

	public void markPresence(Student student) {
		String name = student.getNome();
		studentList.put(name, student);
	}

	public Map<String, Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Map<String, Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "DisciplineClass studentList " + studentList.toString();
	}

}
