package testjsp.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//끝
public class Dao {
	Connection con;	PreparedStatement ps;	ResultSet rs;
	public Dao() {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsptestdb", 
					"root",
					"1234");
		}catch (Exception e) { System.out.println(e);}
	}
}