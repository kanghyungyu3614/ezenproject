package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

@WebServlet("/member/findpassword")
public class findpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public findpassword() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
		String mid =request.getParameter("mid");
		String memail =request.getParameter("midmemail");
	   
		boolean result = MemberDao.getInstance().findpassword(mid, memail);
		String randstr = "";
	    
		if(result) { // 문자난수 15자리 : 랜덤클래스 [임시비밀번호]
			Random random = new Random();
			for(int i=0; i<15; i++) {
				randstr += (char)(random.nextInt(26)+97); // 3. 숫자 -> 강제형변환 [문자로 변환]
			                      // 영소문자[아스키코드] : 97 ~ 122
			                        //random.nextInt(26) == 0~25
				                    //random.nextInt(26) +97== 97~122
				                    //(강제형변환)
				
				
				
			}
			// 해당 회원의 비밀번호를 임시 비밀번호 교체 [업데이트]
			MemberDao.getInstance().passwordchange(mid, randstr);
			
			
			
		}
		response.getWriter().print(randstr);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
