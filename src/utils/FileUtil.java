package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class FileUtil {
	// Alterar aqui o local onde se quer salvar o arquivo
	private static final String fileLocal = "/home/nikolas/Study/2019-2/programacao-para-web/workspace/Trabalho-JSP-nikolas/";

	public static Object getObjectFromFile(String fileName) {
		String finalPath = fileLocal + fileName;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(finalPath))) {
			System.out.println("Tentando ler o objeto do arquivo " + fileName);
			Object object = in.readObject();
			System.out.println(object.toString());
			return object;
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

	public static boolean setObjectFile(Object object, String fileName) {
		String finalPath = fileLocal + fileName;
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(finalPath))) {
			System.out.println("Local para salvar o arquivo " + finalPath);
			System.out.println(fileLocal + fileName);
			out.writeObject(object);

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
		}
		return false;
	}
}
