package models;


import java.util.Map;
import java.util.TreeMap;

public class Course {
	private String courseName;
	private Map<String, Discipline> disciplineList = new TreeMap<String, Discipline>();

	public boolean addDiscipline(Discipline discipline) {
		String name = discipline.getName();
		try {
			disciplineList.put(name, discipline);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Map<String, Discipline> getDisciplineList() {
		return disciplineList;
	}

	public void setDisciplineList(Map<String, Discipline> disciplineList) {
		this.disciplineList = disciplineList;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", disciplineList=" + disciplineList + "]";
	}
}
