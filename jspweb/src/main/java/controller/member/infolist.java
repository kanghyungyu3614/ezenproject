package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class infolist
 */
@WebServlet("/member/infolist")
public class infolist extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<MemberDto> list = 
				MemberDao.getInstance().getinfolist();
		// Dto ------> json
		// 1. JSONObject 여러개 담을수 있는 JSON리스트 선언 
		JSONArray array = new JSONArray();
		for( MemberDto dto : list ) {
			// 2. JSONObject 생성 
			JSONObject object = new JSONObject();	
			// 3. JSONObject 에 엔트리[정보] 담기
			object.put( "mno", dto.getMno() );
			object.put( "mid", dto.getMid() );
			object.put( "mname", dto.getMname() );
			object.put( "mphone", dto.getMphone() );
			object.put( "memail", dto.getMemail() );
			object.put( "maddress", dto.getMaddress() );
			object.put( "mdate", dto.getMdate() );
			object.put( "mpoint", dto.getMpoint() );
			array.add( object ); // 4. JSONObject 객체를 리스트에 담기
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( array );
		
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public infolist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}