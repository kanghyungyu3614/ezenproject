package testjsp.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testjsp.model.dao.testDao;
import testjsp.model.dto.testDto;


@WebServlet("/member/signup")
public class signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		// 1. JSP(HTML) form 입력받은 데이터 요청!!!
		String testid =  request.getParameter("testid");
		String testpassword =  request.getParameter("testpassword");
		String testname =  request.getParameter("testname");
		String testtitle =  request.getParameter("testtitle");
		String testcontent =  request.getParameter("testcontent");
		String testwriter =  request.getParameter("testwriter");
//		private int testno;			
//		private String testid;							
//		private String testpassword;					
//		private String testname;								
//		private String testtitle;							
//		private String testcontent;						
//		private String testwriter;			
//		private String testdate;		
//		private int testpoint;
		
		
		// 2. 변수6개 ---> DTO 객체화 
		testDto dto = new testDto( 
				0, testid,
				testpassword, testname,
				testtitle, testcontent, 
				testwriter, null , 0);
		// 3. 통신 확인 [ HTML ---> JAVA ]
		System.out.println( dto.toString() );
		// 4. DAO 메소드 호출용 객체 선언 
			// 1. 싱글톤객체가 아닐경우 [ 1. 객체생성  2. 객체명.메소드명() ] 
				// MemberDao dao = new MemberDao(); 
				// boolean result =  dao.signup(dto);
			// 2. 싱글톤객체가 있을경우 [ 클래스명.getInstance().메소드명() ]
		boolean result = testDao.getInstance().signup(dto);
				//.signup(dto);
		// 5. 결과 제어
		if( result ) {response.sendRedirect("testjsp/member/success.jsp");}
		else {System.out.println();}
	}
	
	private static final long serialVersionUID = 1L;
    public signup() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
