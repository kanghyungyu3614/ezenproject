package java1.키오스크.관리자;
import java.util.ArrayList;
import java.util.Scanner;
public class AdminView {
	Scanner scanner = new Scanner(System.in);
    AdminController acontrol = new AdminController();
	
	
	public static void main(String[] args) {
	// 싱글톤 객체 호출 
	AdminDAO.getInstance();
	AdminView admin = new AdminView();
	admin.menu();
  
   }
	  //1. 관리자 메뉴 
	  void menu() {
		  while(true) {
			  
			  System.out.println("1.메뉴추가 2.제품추가 3.주문확인 ");
			  try {
				  
				  int ch = scanner.nextInt();
				  if(ch==1) {inMenu();}
				  else if(ch==2) {inProduct();}
				  else if(ch==3) {getOrder();}
				  else { System.out.println("안내) 알수없는 번호입니다.");}
				
			} catch (Exception e) { 
				System.out.println("안내) 선택할수 없는 작동입니다."); 
			    scanner = new Scanner(System.in);
			}
		  }
	  }
	  // 2. 메뉴 추가 화면
	  void inMenu() {
		  System.out.println("추가할 메뉴 이름 : "); String menuname = scanner.next();
		  boolean result = acontrol.inMenu(menuname);
		  if(result) { System.out.println("안내) 메뉴 등록 했습니다.");}
		  else{ System.out.println("안내) 메뉴 실패 했습니다.");}
	  }
	  // 3. 제품 추가 화면 
	  void inProduct() {
		  ArrayList <MenuDTO> list = acontrol.getMenu();
		  
		  System.out.println("메뉴번호\t메뉴이름");
		  for(MenuDTO menu : list) {
			  System.out.println(menu.getMno()+'\t');
			  System.out.println(menu.getMname()+'\t');
		  }
		  System.out.println("추가할 제품의 메뉴 번호 선택 : ");
		  byte mno = scanner.nextByte();
		  
		  System.out.println("제품명 : "); scanner.nextLine();String pname = scanner.nextLine();
		  System.out.println("가격 : "); int pprice = scanner.nextInt();
		  System.out.println("제고 : "); scanner.nextLine();String pcomment = scanner.nextLine();
		  System.out.println("초기 제고 : "); Short pamount = scanner.nextShort();
		  
		  boolean result =
		  acontrol.inProduct(pname, pprice, pcomment, pamount, mno);
		  if(result) { System.out.println("안내) 메뉴 등록 했습니다.");}
		  else{ System.out.println("안내) 메뉴 등록 했습니다.");}
	  }
      // 4. 주문 확인 화면 
	  void getOrder() {}
   }

