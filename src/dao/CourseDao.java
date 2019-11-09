package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import models.Course;

public class CourseDao {
	private static final String fileLocal = "../../";
	private static final String courseFileName = "curso";

	public static Course getCourse() {
		String finalPath = fileLocal + courseFileName;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(finalPath))) {
			System.out.println("Tentando ler o objeto do tipo Course do arquivo " + finalPath);
			Course course = (Course) in.readObject();
			System.out.println(course.toString());
			return course;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassCastException e6) {
			e6.printStackTrace();
		}
		return null;
	}

	public static boolean setCourse(Course course) {
		String finalPath = fileLocal + courseFileName;
		System.out.println("Objeto Course para ser inserido: " + course.toString());
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(finalPath))) {
			System.out.println("Local para salvar o arquivo " + finalPath);
			System.out.println(fileLocal + courseFileName);
			out.writeObject(course);
			return true;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (StreamCorruptedException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} catch (SecurityException e4) {
			e4.printStackTrace();
		} catch (NullPointerException e5) {
			e5.printStackTrace();
		} catch (ClassCastException e6) {
			e6.printStackTrace();
		}
		return false;
	}
}
