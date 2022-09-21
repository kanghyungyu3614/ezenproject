package java1.키오스크.관리자;

import java.util.ArrayList;

public class AdminController {
	
	
	// 2. 메뉴 추가 로직
	boolean inMenu( String menuname ) {
		// 싱글톤객체 메소드 호출 
		return AdminDAO.getInstance().inMenu(menuname); 
	}
	// 3. 메뉴 호출 로직 
	ArrayList< MenuDTO > getMenu() {
		return AdminDAO.getInstance().getMenu();
	}
	// 3. 제품 추가 로직 
	boolean inProduct( String pname , int pprice , 
			String pcomment , short pamount , byte mno  ) {
		ProductDTO dto = new ProductDTO(0, pname, pprice, pcomment, pamount,mno);
		return AdminDAO.getInstance().inProduct(dto);
	}
	
	
	
	// 4. 주문 확인 로직 
	void getOrder( ) { }
	
}