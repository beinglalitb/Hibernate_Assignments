package com.tca;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;

import com.tca.entities.Student;

public class AppDeserialized {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileWriter fw = null;

		try {
			fis = new FileInputStream("resources/student.ser");
			ois = new ObjectInputStream(fis);
			fw = new FileWriter("resources/WriteIntoStudents.csv");

			while (true) {
				try {
					Student s = (Student) ois.readObject();

					System.out.println(s.getRno() + "," + s.getName() + "," + s.getPer() + "\n");
					fw.write(s.getRno() + "," + s.getName() + "," + s.getPer() + "\n");
				} catch (EOFException e) {
					break;
				}
			}
			System.out.println("Records Added In CSV");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fw.close();
			ois.close();
			fis.close();
		}

	}

}
