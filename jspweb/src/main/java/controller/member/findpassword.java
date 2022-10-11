package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class findpassword
 */
@WebServlet("/member/findpassword")
public class findpassword extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. ajax 변수 요청 
		String mid =  request.getParameter("mid");
		String memail =  request.getParameter("memail");
		// 2. DB메소드 호출 
		boolean result =  MemberDao.getInstance().findpassword(mid, memail);
		
		String randstr = "";	// 2. 랜덤 문자를 저장할 문자열[ 임시 비밀번호 ]
		// 3. 아이디와 이메일이 동일할경우[ true] 에만 임시비밀번호 생성 
		if( result ) { 	// 문자난수 15자리 : 랜덤클래스 [ 임시비밀번호 ]  
			Random random = new Random(); // 1. 랜덤객체 선언 
			for( int i = 0 ; i<15 ; i++ ) {	// 15회 
				randstr += (char)(random.nextInt(26)+97); // 3. 숫자 -> 강제형변환 [ 문자로 변환 ] 
									// 영소문자[아스키코드] : 97~122
									// random.nextInt(26);  	: 0 ~ 25
									// random.nextInt(26)+97	: 97 ~ 122
									// (char)(random.nextInt(26)+97) : a ~ z
									// random.nextInt( 개수 )+시작번호
			}
			// 해당 회원의 비밀번호를 임시 비밀번호 교체[업데이트] 
			MemberDao.getInstance().passwordchange(mid, randstr);
		}
		// 4. 반환
		response.getWriter().print( randstr ); // ajax 에게 임시비밀번호 전송
		
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}