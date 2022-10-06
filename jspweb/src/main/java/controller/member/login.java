package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

@WebServlet("/member/login") // url 정의 : 해당 클래스로 돌어올수 있는 경로 선언 [매핑]
public class login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String mpassword= request.getParameter("mpassword");
		
		boolean result = MemberDao.getInstance().login(mid, mpassword);
		if(result) {
			response.sendRedirect("/jspweb/index.jsp");
		}
		else { response.sendRedirect("/jspweb/login.jsp");}
		
		
		
		
	}
	private static final long serialVersionUID = 1L;
       
     
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
