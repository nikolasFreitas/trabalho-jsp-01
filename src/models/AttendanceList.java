package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class AttendanceList implements Comparable<LocalDate>, Serializable {
	/**
	 * General serial version
	 */
	private static final long serialVersionUID = 1774360551001149093L;
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

	@Override
	public int compareTo(LocalDate date) {		
		return date.compareTo(date);
	}

}
