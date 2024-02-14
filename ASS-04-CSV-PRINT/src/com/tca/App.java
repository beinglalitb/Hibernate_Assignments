package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class App {

	public static void main(String[] args) throws Exception 
	{
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String dbURL = "jdbc:mysql://localhost:3306/hfbdb";
		String user = "root";
		String password = "root123";

		List<Student> Pass = new ArrayList<>();
		List<Student> Fail = new ArrayList<>();
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, user, password);
			ps = con.prepareStatement("Select * from student");
			
			rs = ps.executeQuery();
		
			while(rs.next())
			{
				int rno = rs.getInt("rno");
				String name = rs.getString("name");
				double per = rs.getDouble("per");	
				
				Student ob = new Student(rno, name, per);
				
				if(per >= 35)
					Pass.add(ob);	
				else
					Fail.add(ob);
			}
			
			System.out.println("List of Passed Students : ");
			for(Student S : Pass)
			{
				System.out.println(S);
			}
			
			System.out.println("List of Failed Students : ");
			for(Student S : Fail)
			{
				System.out.println(S);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			rs.close();
			con.close();
		}

	}

}
