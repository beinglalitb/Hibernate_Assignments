package com.tca;

import java.io.BufferedReader;
import java.io.FileReader;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.tca.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		FileReader fr = null;
		BufferedReader br = null;
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			Configuration configuration = new Configuration();
			configuration.configure(); // load & parse cfg.xml file

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();

			fr = new FileReader("resources/student.csv");
			br = new BufferedReader(fr);

			while (true) {
				String line = br.readLine();

				if (line == null) {
					break;
				}

				String tok[] = line.split(",");

				if (tok.length < 3) {
			        // Skip this line or handle the error as needed
			        continue;
			    }
				
				Student student = new Student();

				int rno = Integer.parseInt(tok[0]);
				String name = tok[1];
				double per = Double.parseDouble(tok[2]);

				student.setRno(rno);
				student.setName(name);
				student.setPer(per);

				if (rno != 0 && !name.isEmpty() && per != 0.0)
					session.save(student);
			}

			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			br.close();
			session.close();
			sessionFactory.close();
		}
	}
}
