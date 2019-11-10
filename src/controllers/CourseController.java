package controllers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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

	public Set<String> getDisciplineKeys() {
		return course.getDisciplineList().keySet();
	}

	public boolean addDisciplineClass(DisciplineClass disciplineClass, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		return discipline.addNewClass(disciplineClass);
	}

	public void addDiscipline(Discipline discipline) {
		course.addDiscipline(discipline);
	}

	public void addStudent(Student student, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);

		discipline.getDisciplineClassList().getLast().getStudentList().put(student.getName(), student);
	}

	public boolean addAttendence(AttendanceList attendanceList, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		return discipline.getDisciplineClassList().getLast().getAttendanceList().add(attendanceList);
	}

	public boolean markPresence(Student student, String disciplineName) {
		Discipline discipline = getDiscipline(disciplineName);
		String name = student.getName();
		if (getStudentListFromDisciplineClass(disciplineName).contains(student)) {
			AttendanceList attendanceList = discipline.getDisciplineClassList().getLast().getAttendanceList().getLast();
			try {
				return attendanceList.addStudentKey(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
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

	public Set<Student> getStudentListFromDisciplineClass(String disciplineName) {
		Set<Student> studentNameList = new HashSet<>();
		Discipline discipline = getDiscipline(disciplineName);
		discipline.getDisciplineClassList().stream().forEach(disciplineClassCustom -> {
			studentNameList.addAll(disciplineClassCustom.getStudentList().values());
		});

		return studentNameList;
	}
	
	public DisciplineClass getDisciplineClassFromStudent(String studentName, String disciplineName) {
		DisciplineClass disciplineClassHolder;
		disciplineClassHolder = course.getDisciplineList()
				.get(disciplineName)
				.getDisciplineClassList()
				.stream()
				.filter(dc -> dc.getStudentList().containsKey(studentName))
				.findFirst()
				.orElse(null);
			
		return  disciplineClassHolder;
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
