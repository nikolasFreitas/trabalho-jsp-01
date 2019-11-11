package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dao.CourseDao;
import models.AttendanceList;
import models.Course;
import models.Discipline;
import models.DisciplineClass;
import models.Student;

public class CourseController {
	private Course course;

	public CourseController() {
		course = CourseDao.getCourse();
	}

	private void saveModel() {
		CourseDao.setCourse(course);
		course = CourseDao.getCourse();
	}

	public Set<String> getDisciplineKeys() {
		return course.getDisciplineList().keySet();
	}

	public void addDisciplineClass(DisciplineClass disciplineClass, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		discipline.addNewClass(disciplineClass);
		saveModel();
	}

	public void addDiscipline(Discipline discipline) {
		course.addDiscipline(discipline);
		saveModel();
	}

	public void addStudent(Student student, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);

		discipline.getDisciplineClassList().getLast().getStudentList().put(student.getName(), student);
		saveModel();
	}

	public boolean addAttendence(AttendanceList attendanceList, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		boolean works = discipline.getDisciplineClassList().getLast().getAttendanceList().add(attendanceList);
		if (works) {
			System.out.println("Foi adicionado a nova lista de chamada");
			saveModel();
		}

		return works;
	}

	public boolean markPresence(String studentName, String disciplineName) {

		AttendanceList attendanceList = getDisciplineClassFromStudent(studentName, disciplineName).getAttendanceList()
				.getLast();
		
		System.out.println();
		try {
			boolean works = attendanceList.addStudentKey(studentName);

			if (works) {
				saveModel();
			}

			return works;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private Discipline getDiscipline(String disciplineName) throws IllegalArgumentException {
		Discipline discipline = course.getDisciplineList().get(disciplineName);
		if (discipline != null) {
			return discipline;
		}

		throw new IllegalArgumentException("Disciplina \"" + disciplineName + "\" não encontranda");
	}

	public List<Student> getStudentListFromDisciplineClass(String disciplineName) {
		Set<Student> studentNameList = new HashSet<>();
		Discipline discipline = getDiscipline(disciplineName);
		discipline.getDisciplineClassList().stream().forEach(disciplineClassCustom -> {
			studentNameList.addAll(disciplineClassCustom.getStudentList().values());
		});
		return new ArrayList<Student>(studentNameList);
	}

	public DisciplineClass getDisciplineClassFromStudent(String studentName, String disciplineName) {
		DisciplineClass disciplineClassHolder;
		disciplineClassHolder = course
				.getDisciplineList()
				.get(disciplineName)
				.getDisciplineClassList()
				.stream()
				.filter(dc -> dc.getStudentList().containsKey(studentName))
				.findFirst()
				.orElse(null);

		return disciplineClassHolder;
	}

//	Retorna todas os estudantes
	public Set<Student> getStudentListFromDisciplineClass() {
		Set<Student> studentList = new HashSet<>();

		List<Discipline> disciplineList = new LinkedList<Discipline>(course.getDisciplineList().values());

		disciplineList.stream().forEach(discipline -> {
			discipline.getDisciplineClassList().stream().forEach(disciplineClassCustom -> {
				studentList.addAll(disciplineClassCustom.getStudentList().values());
			});

		});

		return studentList;

	}

	public List<Discipline> getDisciplineByStudent(String studentName) {
		List<Discipline> disciplineHolder;

		disciplineHolder = course.getDisciplineList().values().stream().filter(discipline -> {
			return discipline.getDisciplineClassList().stream().anyMatch(classList -> {
				return classList.getStudentList().containsKey(studentName);
			});
		}).collect(Collectors.toList());

		return disciplineHolder;
	}

	public Course getCourse() {
		return this.course;
	}
}
