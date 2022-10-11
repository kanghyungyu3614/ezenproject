package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

@WebServlet("/member/signup") // 패키지/파일명
public class signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 1. JSP(HTML) form 입력받은 데이터 요청!!!
		String mtitle = request.getParameter("mtitle"); 
		String mcontent =  request.getParameter("mcontent");
		String mname =  request.getParameter("mwriter");
		String mpassword =  request.getParameter("mpassword");
		String mpasswordconfirm =  request.getParameter("mpasswordconfirm");
		
		// 2. 변수6개 ---> DTO 객체화 
		MemberDto dto = new MemberDto( 
				0, mtitle,
				mcontent, mname,
				mpassword,null , 0);
		// 3. 통신 확인 [ HTML ---> JAVA ]
		System.out.println( dto.toString() );
		// 4. DAO 메소드 호출용 객체 선언 
			// 1. 싱글톤객체가 아닐경우 [ 1. 객체생성  2. 객체명.메소드명() ] 
				// MemberDao dao = new MemberDao(); 
				// boolean result =  dao.signup(dto);
			// 2. 싱글톤객체가 있을경우 [ 클래스명.getInstance().메소드명() ]
		boolean result = MemberDao.getInstance().signup(dto);
		// 5. 결과 제어
		if( result ) {response.sendRedirect("/testjsp/member/success.jsp");} // 이동시키고 싶은 파일명 
		else {System.out.println();}
		
		
	}
	private static final long serialVersionUID = 1L;
       

    public signup() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
	}


}
