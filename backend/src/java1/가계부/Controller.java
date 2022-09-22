package java1.가계부;

import java.util.ArrayList;

public class Controller {
	
	// 1. 내용추가 컨트롤러
	boolean create( String edate , 
			int emoney , String ecomment) {
		// 매개변수3개 --> 1개 dto 객체 선언 
		ExpenseDTO dto = new ExpenseDTO( 0 , edate,
				emoney, ecomment);
		// dto객체 -> dao 메소드 
		return ExpenseDAO.getInstance().create( dto );
	}
	
	// 2. 내용호출 컨트롤러
	ArrayList< ExpenseDTO > read (){
		return ExpenseDAO.getInstance().read();
	}
	
	//3. 내용수정 컨트롤러
	boolean update(int eno,String edate,int emoney,String ecomment) {
		
		return ExpenseDAO.update(new ExpenseDTO(eno,edate,emoney,ecomment));
	}
	
	
	//4. 내용삭제 컨트롤러
	boolean delete (int eno) {
		return ExpenseDAO.getInstance().delete(eno);
	}

}


