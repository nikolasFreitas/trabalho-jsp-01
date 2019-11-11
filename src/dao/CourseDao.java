package dao;

import models.Course;
import utils.FileUtil;

public class CourseDao {
	private static final String courseFileName = "course";

	public static Course getCourse() {
		try {
			Course course = (Course) FileUtil.getObjectFromFile(courseFileName);
			if (course != null) {
				System.out.println(course.toString());				
			}
			return course;
		} catch (ClassCastException e6) {
			e6.printStackTrace();
		}
		return null;
	}

	public static boolean setCourse(Course course) {
		System.out.println("Objeto Course para ser inserido");
		try {
			FileUtil.setObjectFile(course, courseFileName);
			return true;
		} catch (ClassCastException e6) {
			e6.printStackTrace();
		}
		return false;
	}
}
