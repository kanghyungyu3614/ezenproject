package testjsp.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/signup")
public class signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		// 1. JSP(HTML) form 입력받은 데이터 요청!!!
		String mid =  request.getParameter("mid");
		String mpassword =  request.getParameter("mpassword");
		String mpasswordconfirm =  request.getParameter("mpasswordconfirm");
		String mname =  request.getParameter("mname");
		String mphone =  request.getParameter("mphone");
		String memail =  request.getParameter("memail");
		
		//주소 4개 요청
		String maddress1 = request.getParameter("maddress1");
		String maddress2 = request.getParameter("maddress2");
		String maddress3 = request.getParameter("maddress3");
		String maddress4 = request.getParameter("maddress4");
		
		String maddress = maddress1+","+maddress2+","+maddress3+","+maddress4; 	
		
		
		
	
		
		
		
		
		
		doGet(request, response);
	}
	
	private static final long serialVersionUID = 1L;
    public signup() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
