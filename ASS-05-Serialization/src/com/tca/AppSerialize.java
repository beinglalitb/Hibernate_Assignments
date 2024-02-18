package com.tca;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

import com.tca.entities.Student;

public class AppSerialize {

	public static void main(String[] args) throws Exception {
		FileReader fr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fr = new FileReader("resources/student.csv");
			br = new BufferedReader(fr);
			fos = new FileOutputStream("resources/student.ser");
			oos = new ObjectOutputStream(fos);

			while (true) {
				String line = br.readLine();

				if (line == null) {
					break;
				}

				String tok[] = line.split(",");

				try {
					Student s = new Student();

					int rno = Integer.parseInt(tok[0]);
					String name = tok[1];
					double per = Double.parseDouble(tok[2]);

					s.setRno(rno);
					s.setName(name);
					s.setPer(per);

					if (rno != 0 && !name.isEmpty() && per != 0.0) {
						oos.writeObject(s);
					}
				} catch (Exception e) {
					System.out.println("Ignored : " + line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			oos.close();
			fos.close();
			br.close();
			fr.close();
		}
	}
}
