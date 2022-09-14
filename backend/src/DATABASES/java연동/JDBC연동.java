package DATABASES.java연동;

import java.sql.DriverManager; 
import java.sql.Connection;   //db연동
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC연동 {

	public static void main(String[] args) {
		
		// JDBC : 자바와 DB 연동
			// 1. 라이브러리 필요 [ mysql-connector-java-8.0.30.jar ]
				// * jar : 미리 만들어진 클래스들의 집합 
			// 2. 해당 프로젝트 라이브러리 추가 
				// 1. 해당 프로젝트 오른쪽클릭 
				// 2. build path -> configure build path 
				// 3. Libraries 탭 선택 
				// 4. add External Jar -> 해당 jar 파일 선택 
					// * 해당 jar 파일의 경로 변경되면 라이브러리 실행불가능 
				// 5. apply 
			// 3.  미리 만들어진 JDBC 관련된 클래스를 사용할수 있다. 
				// 1. Connection : 인터페이스 
				// 2. DriverManager : 클래스 
					// 3. .getConnection( db주소 , db계정명 , db비밀번호 )  : 메소드 
	
			// MYSQL 연동 할때 해당 클래스에서 예외(오류 발생 )
				// * 연동 실패 했을경우 그에 대한 대처 코드
				// 해결방안 : 예외처리 [ try ~ catch ]
		
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
//			String sql = "insert into member values('tess','나훈아','경기 부천시 중동')";
//			// 2. sql 조작 인터페이스
//			PreparedStatement ps = con.prepareStatement(sql);
//			// 3. SQL 실행 
//			ps.executeUpdate();
//			
//			// 아이유 추가 
//			// 1. sql 문법 작성 
//			sql = "insert into member values('iyou' , '아이유' , '인천 남구 주안동')";
//			// 2. sql 조작 인터페이스 
//			ps = con.prepareStatement(sql);
//			// 3. sql 실행
//			ps.executeUpdate();
//			
//			// 박진영 추가 
//			sql = "insert into member values('jyp' , '박진영' , '경기 고양시 장항동')";
//			ps = con.prepareStatement(sql);
//			ps.executeUpdate();

//			// 박진영 주소 변경  
//			String sql = "update member set member_addr ='경기도 안산시 상록구' where member_id='jyp'";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.executeUpdate();		
//
//			// 아이유 레코드 삭제  
//			sql = "delete from member where member_id='iyou'";
//			ps = con.prepareStatement(sql);
//			ps.executeUpdate();	
			
			// 모든 맴버 호출
			String sql = "select * from member";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery(); // 쿼리[테이블 조작된 결과]
                // 결과가 레코드[행] 여러개 존재하기 때문에
			    // 반복문 이용한 레코드 하나씩 출력
			       // null -> 검색레코드1 -> 검색레코드2
			       // .next() 다음 레코드 호출
			while(rs.next()){
				System.out.println("회원아이디 : " + rs.getString(1)+"\t");
				System.out.println("회원명 : " + rs.getString(2)+"\t");
				System.out.println("회원주소 : " + rs.getString(3)+"\n");
			}
			
		}catch( Exception e ) { System.out.println("연동 실패 : " + e ); }
		
		
	}
}

