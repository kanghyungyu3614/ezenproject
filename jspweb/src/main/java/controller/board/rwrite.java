package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dao.MemberDao;

@WebServlet("/reply/rwrite")
public class rwrite extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		// 댓글내용 , 작성자번호, 게시물번호
		String rcontent  = request.getParameter("rcontent");
		System.out.println(rcontent);
		int mno =  MemberDao.getInstance().getMno((String) request.getSession().getAttribute("mid"));
		int bno =  (Integer)request.getSession().getAttribute("bno");
		if(mno == 0) {response.getWriter().print("0");return;}
		// 2. db처리
		boolean result = BoardDao.getInstance().rwrite(rcontent, mno, bno);
		// 3. 결과 반환
		if(result) {response.getWriter().print("1");}
		else{response.getWriter().print("2");}
	}
	private static final long serialVersionUID = 1L;
       
    public rwrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
