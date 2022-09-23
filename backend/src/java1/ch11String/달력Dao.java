package java1.ch11String;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class 달력Dao {
  private Connection con;
  private  PreparedStatement ps;
  private ResultSet rs;
  private static 달력Dao dao =new 달력Dao(); //싱글톤
   
    public static 달력Dao getInstance() {return dao;}
    
  private 달력Dao() {
	  try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "root", "1234");
		} catch (Exception e) { System.out.println("DB오류:"+e);}
  }  
  
  // 3. sql 메소드 
  boolean 일정추가 (String cdate, String ccomment) {
    String sql ="insert into calendar values (null, ?,?)";	  
	  try {
		ps = con.prepareStatement(sql);
		ps.setString(1, cdate);
		ps.setString(2, ccomment);
		ps.executeUpdate();
		return true;
	} catch (Exception e) {System.out.println(e);}
	  return false; 
  }
  
  HashMap<Integer, ArrayList<String>> 일정출력 (String year, String month) {
     String sql ="SELECT * FROM test.calendar "
     		+ "select * "
     		+ "from calendar "
     		+ "where substring(cdate,1,4) = ? and substring(cdate,6,2) = ? ;";
	    HashMap<Integer, ArrayList<String>>map =new HashMap<>();
	    try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, year);
			ps.setString(2, month);
		    rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	ArrayList<String> values= new ArrayList<>();
		    	values.add(rs.getString(2));
		    	values.add(rs.getString(3));
		    	
		    	map.put(rs.getInt(1), values);
		    	return map;
		    }
			
		} catch (Exception e) {System.out.println(e);}
		 return map;
     
     
  }
  
  
  
  
}
