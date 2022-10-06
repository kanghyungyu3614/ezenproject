package jspweb.controller.member;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.model.dao.MemberDao;
import jspweb.model.dto.MemberDto;

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public signup() {super();}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 입력
//		Scanner scan = new Scanner(System.in);
//		System.out.print("아이디 : ");  String id = scan.next();
//        System.out.print("비밀번호 : "); String pw = scan.next();
//        System.out.print("이름 : ");    String name = scan.next();
//        System.out.print("연락처 : ");   String phone = scan.next();
		String id = request.getParameter(("id"));
		String pw = request.getParameter(("pw"));
		String name = request.getParameter(("name"));
		String phone = request.getParameter(("phone"));
		
        // 2. 입력받은 변수 4개를 DAO 이동하자 [변수4개 VS DTO 1개 VS 컬렉션 프레임워크 ]
           // 1. 변수 4개 -> DTO 객체화
        MemberDto dto = new MemberDto(id,pw,name,phone);
           // 2. 테스트 [ 객체 필드 정보 확인 ]
        System.out.println(dto.toString());
           // 3. Dao 싱글톤 객체 호출 한 다음 메소드 호출
        boolean result = MemberDao.getInstance().signup(dto);
        if(result) { System.out.println("회원가입 성공");}
        else {System.out.println("회원가입 실패");}
                
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
