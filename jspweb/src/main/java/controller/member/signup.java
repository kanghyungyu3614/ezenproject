package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

// @WebServlet("URL정의") : 해당 클래스를 호출하는 URL 정의 
@WebServlet("/member/signup") // 해당 클래스로 매핑(연결) URL 설정 [ 패키지 경로x ]
public class signup extends HttpServlet {

	protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. JSP(HTML) form 입력받은 데이터 요청!!!
		String mid =  request.getParameter("mid");
		String mpassword =  request.getParameter("mpassword");
		String mpasswordconfirm =  request.getParameter("mpasswordconfirm");
		String mname =  request.getParameter("mname");
		String mphone =  request.getParameter("mphone");
		String memail =  request.getParameter("memail");
		String maddress =  request.getParameter("maddress");
		// 2. 변수6개 ---> DTO 객체화 
		MemberDto dto = new MemberDto( 
				0, mid,
				mpassword, mname,
				mphone, memail, 
				maddress, null , 0);
		// 3. 통신 확인 [ HTML ---> JAVA ]
		System.out.println( dto.toString() );
		// 4. DAO 메소드 호출용 객체 선언 
			// 1. 싱글톤객체가 아닐경우 [ 1. 객체생성  2. 객체명.메소드명() ] 
				// MemberDao dao = new MemberDao(); 
				// boolean result =  dao.signup(dto);
			// 2. 싱글톤객체가 있을경우 [ 클래스명.getInstance().메소드명() ]
		boolean result = MemberDao.getInstance().signup(dto);
		// 5. 결과 제어
		if( result ) {System.out.println("회원가입 성공");}
		else { System.out.println("회원가입 실패");}
		doGet(request, response);
	}
	
	private static final long serialVersionUID = 1L;
    
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}

