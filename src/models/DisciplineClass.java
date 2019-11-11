package models;

import java.io.Serializable;
import java.util.*;

public class DisciplineClass implements Serializable {
	private static final long serialVersionUID = -8246309921122652770L;

	private int id;
	private Map<String, Student> studentList;
	private LinkedList<AttendanceList> attendanceList;

	public DisciplineClass() {
		super();
		studentList = new TreeMap<String, Student>();
		attendanceList = new LinkedList<AttendanceList>();
	}

	public DisciplineClass(Map<String, Student> studentList, LinkedList<AttendanceList> attendanceList, int id) {
		super();
		this.studentList = studentList;
		this.attendanceList = attendanceList;
		this.id = id;
	}

	public void addStudent(Student student) {
		studentList.put(student.getName(), student);
	}

	public Map<String, Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Map<String, Student> studentList) {
		this.studentList = studentList;
	}

	public LinkedList<AttendanceList> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(LinkedList<AttendanceList> attendanceList) {
		this.attendanceList = attendanceList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
