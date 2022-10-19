package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;
import model.dao.MemberDao;

/**
 * Servlet implementation class rwrite
 */
@WebServlet("/reply/rwrite")
public class rwrite extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [ 공통 ]
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type"); // 타입 요청 [ 0:댓글 1:대댓글[답글] ]
		String rcontent = request.getParameter("rcontent");	
		int mno = MemberDao.getInstance().getMno( 
				(String)request.getSession().getAttribute("mid")
				) ;
		if( mno == 0 ) { response.getWriter().print("0");  return; } // **비로그인 일경우 반환
		int bno = (Integer)request.getSession().getAttribute("bno");
		boolean result = false;
		// 2. db처리 
		if( type.equals("reply") ) { // 댓글 일경우 
			result = BoardDao.getInstance().rwrite( rcontent , mno , bno );
		}else if( type.equals("rereply") ) { // 대댓글 일경우 
			int rindex = Integer.parseInt( request.getParameter("rno") );	
			result = BoardDao.getInstance().rrwrite( rcontent , mno , bno , rindex );
		}
		// 3. 결과 반환 
		if( result )response.getWriter().print("1");	// 성공
		else response.getWriter().print("2");			// db오류
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}