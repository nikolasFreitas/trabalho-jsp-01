package models;

import java.util.ArrayList;

public class Discipline {
	private String name;
	private ArrayList<DisciplineClass> disciplineClassList = new ArrayList<DisciplineClass>();

	public Discipline() {

	}
	
	public Discipline(String name) {
		this.name = name;
	}

	public boolean addNewClass(DisciplineClass disciplineClass) {
		return disciplineClassList.add(disciplineClass);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<DisciplineClass> getDisciplineClassList() {
		return disciplineClassList;
	}

	public void setDisciplineClassList(ArrayList<DisciplineClass> disciplineClassList) {
		this.disciplineClassList = disciplineClassList;
	}

}
