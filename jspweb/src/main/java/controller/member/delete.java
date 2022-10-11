package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/member/delete")
public class delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String mpassword = request.getParameter("mpassword");
		
		String mid = (String)request.getSession().getAttribute("mid");
		
		boolean result = MemberDao.getInstance().delete(mid, mpassword);
		
		response.getWriter().print(result);
		
		
	}
	
	
	
	
	private static final long serialVersionUID = 1L;
       
    public delete() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
