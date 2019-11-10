package main;

import java.util.ArrayList;

import dao.CourseDao;
import models.AttendanceList;
import models.Course;
import models.Discipline;
import models.DisciplineClass;
import models.Student;

public class Start {
	private Course course = new Course();
	private ArrayList<Discipline> disciplineList = new ArrayList<Discipline>();
	private ArrayList<DisciplineClass> disciplineClassesList = new ArrayList<DisciplineClass>();
	private ArrayList<AttendanceList> attendanceLists = new ArrayList<AttendanceList>();
	private ArrayList<Student> studentList = new ArrayList<Student>();

	public Start() {

	}
	
	public void mockInfos() {
		createStudent();
		createAttendanceList();
		craeteDisciplinesClass();
		createDisciplines();
		createCourse();
	}
	
	public void verifyCourse() {
		CourseDao.setCourse(this.course);
	}
	
	public void readCourse() {
		this.course = CourseDao.getCourse();
	}

	private void createStudent() {
		Student student = new Student();
		student.setName("Getúlio");
		student.setId(1);

		Student student2 = new Student();
		student2.setName("Jayme");
		student.setId(2);

		this.studentList.add(student);
		this.studentList.add(student2);
	}

	private void createAttendanceList() {
		AttendanceList attendance = new AttendanceList();
		AttendanceList attendance2 = new AttendanceList();
		this.attendanceLists.add(attendance);
		this.attendanceLists.add(attendance2);
		for (Student student : studentList) {
			attendance.addStudentKey(student.getName());
			attendance2.addStudentKey(student.getName());
		}
	}

	private void craeteDisciplinesClass() {
		DisciplineClass disciplineClass = new DisciplineClass();
		this.disciplineClassesList.add(disciplineClass);
		for (int i = 0; i < studentList.size(); i++) {
			disciplineClass.addStudent(studentList.get(i));
		}
	}

	private void createDisciplines() {
		Discipline discipline = new Discipline();
		discipline.setName("Matemática");
		Discipline discipline2 = new Discipline();
		discipline2.setName("História");
		
		disciplineList.add(discipline);
		disciplineList.add(discipline2);
		
		for (DisciplineClass disciplineClass : disciplineClassesList) {
			
			discipline.addNewClass(disciplineClass);
			discipline2.addNewClass(disciplineClass);
		}

	}
	
	private void createCourse() {
		this.course.setCourseName("Sistemas para internet");
		for (Discipline discipline : disciplineList) {
			course.addDiscipline(discipline);						
		}
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ArrayList<Discipline> getDisciplineList() {
		return disciplineList;
	}

	public void setDisciplineList(ArrayList<Discipline> disciplineList) {
		this.disciplineList = disciplineList;
	}

	public ArrayList<DisciplineClass> getDisciplineClassesList() {
		return disciplineClassesList;
	}

	public void setDisciplineClassesList(ArrayList<DisciplineClass> disciplineClassesList) {
		this.disciplineClassesList = disciplineClassesList;
	}

	public ArrayList<AttendanceList> getAttendanceLists() {
		return attendanceLists;
	}

	public void setAttendanceLists(ArrayList<AttendanceList> attendanceLists) {
		this.attendanceLists = attendanceLists;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	

}
