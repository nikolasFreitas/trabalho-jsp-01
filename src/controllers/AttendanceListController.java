package controllers;

import java.util.Set;

import models.AttendanceList;

public class AttendanceListController {
	private AttendanceList attendenceListModel = new AttendanceList();

	public AttendanceList getAttendenceListModel() {
		return attendenceListModel;
	}

	public boolean addStudent(String studentKey) {		
		Set<String> studentListKey = attendenceListModel.getStudentListKey();
		boolean isAdd = studentListKey.add(studentKey);
		attendenceListModel.setStudentListKey(studentListKey);
		
		return isAdd;
	}
	
	
}
