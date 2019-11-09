package models;

import java.io.Serializable;
import java.util.LinkedList;

public class Discipline implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 526924691299654001L;
	private String name;
	private LinkedList<DisciplineClass> disciplineClassList = new LinkedList<DisciplineClass>();

	public Discipline() {
	}
	
	public Discipline(String name, LinkedList<DisciplineClass> disciplineClassList) {
		this.name = name;
		this.disciplineClassList = disciplineClassList;
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

	public LinkedList<DisciplineClass> getDisciplineClassList() {
		return disciplineClassList;
	}

	public void setDisciplineClassList(LinkedList<DisciplineClass> disciplineClassList) {
		this.disciplineClassList = disciplineClassList;
	}

}
