package controllers;

import models.AttendanceList;

public class AttendanceListController {
	private AttendanceList attendenceListModel = new AttendanceList();

	public boolean addStudent(String studentKey) {		
		return attendenceListModel.addStudentKey(studentKey);
	}
	
	public String attendenceListToString() {
		return attendenceListModel.toString();
	}

}
