package models;

import java.util.LinkedHashSet;
import java.util.Set;

public class AttendanceList {
	Set<String> studentListKey = new LinkedHashSet<String>();
	
	public boolean addStudentKey(String studentKey) {
		try {
			return studentListKey.add(studentKey);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public Set<String> getStudentListKey() {
		return studentListKey;
	}

	public void setStudentListKey(Set<String> studentListKey) {
		this.studentListKey = studentListKey;
	}
	
	@Override
	public String toString() {
		StringBuilder stringToSend = new StringBuilder("\n");
		for (String string : studentListKey) {
			stringToSend.append(string + "\n");
		}
		
		return stringToSend.toString();
	}

}
