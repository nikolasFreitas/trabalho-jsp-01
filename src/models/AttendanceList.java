package models;

import java.util.LinkedHashSet;
import java.util.Set;

public class AttendanceList {
	Set<String> studentListKey = new LinkedHashSet<String>();

	public Set<String> getStudentListKey() {
		return studentListKey;
	}

	public void setStudentListKey(Set<String> studentListKey) {
		this.studentListKey = studentListKey;
	}

}
