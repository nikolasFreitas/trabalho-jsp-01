package models;

import java.util.*;

public class DisciplineClass {
	private Map<String, Student> studentList = new TreeMap<String, Student>();
	private LinkedList<AttendanceList> attendanceList = new LinkedList<AttendanceList>();

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
	
	public void addStudent(Student student) {
		studentList.put(student.getName(), student);
	}

}
