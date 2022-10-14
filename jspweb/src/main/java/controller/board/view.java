package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class view
 */
@WebServlet("/board/view")
public class view extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 
		//int bno = Integer.parseInt( request.getParameter("bno") ) ;
		//System.out.println( bno );
		
		// 1. 세션 요청 [ 세션(Object) --> String -> int ] 
			// 다형성 : 부모가 자식으로 강제 형변환 가능 
		int bno = (Integer)request.getSession().getAttribute("bno");
		// 2. DAO 처리 
		System.out.println("bno 는?" +bno);
		BoardDto dto = 
		BoardDao.getInstance().getboard(bno);
		// 3. DTO --> JSON 형변환
		System.out.println("dto 는?" +dto);
		JSONObject object = new JSONObject();
		object.put("bno", dto.getBno());
		object.put("btitle", dto.getBtitle());
		object.put("bcontent", dto.getBcontent());
		object.put("mid", dto.getMid() );
		object.put("bfile", dto.getBfile() );
		
			// * 삭제 , 수정 버튼을 활성화를 위한 식별변수 선언 [ 본인글 판단 ]
			// 1. 로그인한 세션 정보 호출 
			String mid = (String)request.getSession().getAttribute("mid");
			System.out.println(  mid );
			System.out.println(  dto.getMid() );
			// 2. 로그인한 세션과 현재 게시물의 작성자와 일치하면
			if( mid != null && mid.equals( dto.getMid() )) {
			// 로그인 했으   면서  로그인된아이디와 현재게시물의 작성자 아이디 가 동일하면 
				object.put("btnaction", true );
			}
		
		
		// 4. 응답 
		response.setCharacterEncoding("utf-8");
		response.getWriter().print( object );
		
		
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
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