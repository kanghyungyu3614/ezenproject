package DATABASES.java연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC연동2 {
public static void main(String[] args) {		
		try { 
			// 만일 try 괄호 안에서 예외[오류]가 발생하면 catch로 코드흐름이 이동 
			// 예외가 없으면 try 괄호만 정상실행
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버 이름
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shop_db3", 
					"root",
					"1234");
			System.out.println("DB 연동 성공");
			
			
//		// * JDBC에서 SQL 조작 
//		// 1. 테이블에 데이터 추가 
//			// 1. sql 문법을 " " 감싸고 문자열 변수 에 저장 
//			String sql = "insert into product values('바나나','1500','2021-07-01','델몬트','17')";
//			// 2. sql 조작 인터페이스
//			PreparedStatement ps = con.prepareStatement(sql);
//			// 3. SQL 실행 
//			ps.executeUpdate();
//			
//			// 카스 추가 
//			// 1. sql 문법 작성 
//			sql = "insert into product values('카스','2500','2022-03-01','OB','3')";
//			// 2. sql 조작 인터페이스 
//			ps = con.prepareStatement(sql);
//			// 3. sql 실행
//			ps.executeUpdate();
//			
//			// 삼각김밥 추가 
//			sql = "insert into product values('삼각김밥','800','2023-09-01','CJ','22')";
//			ps = con.prepareStatement(sql);
//			ps.executeUpdate();
	        
			
			//1. 카스의 재고수량을 10로 수정
			String sql = "update product set amount ='10' where company ='OB'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();	
			//2. 삼각김밥 제거
			sql = "delete from product where company ='CJ'";
			ps = con.prepareStatement(sql);
		    ps.executeUpdate();		
		 	//3. 모든 제품의 정보를  console 출력
			// 모든 맴버 호출
			sql = "select * from product";
			ps = con.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery(); // 쿼리[테이블 조작된 결과]
                // 결과가 레코드[행] 여러개 존재하기 때문에
			    // 반복문 이용한 레코드 하나씩 출력
			       // null -> 검색레코드1 -> 검색레코드2
			       // .next() 다음 레코드 호출
			while(rs.next()){
				System.out.println("제품이름 : " + rs.getString(1)+"\t");
				System.out.println("가격 : " + rs.getString(2)+"\t");
				System.out.println("유통기간 : " + rs.getString(3)+"\t");
				System.out.println("회사 : " + rs.getString(4)+"\t");
				System.out.println("재고량 : " + rs.getString(5)+"\t");
			}			
			
			
		}catch( Exception e ) { System.out.println("연동 실패 : " + e ); }
		
		
	}
}
