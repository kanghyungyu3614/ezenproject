package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.multipart.LimitedServletInputStream;

import model.dao.BoardDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class list
 */
@WebServlet("/board/list")
public class list extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청x
		   //  페이징처리 필요한 변수 요청 ,페이지당 개시물수 
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		System.out.println("listsize는 ?:"+listsize);
		
		// 2. 전체페이지수 
		int totalsize = BoardDao.getInstance().gettotalsize();
		
		// 3. 전체 페이지수 계산
		int totalpage = 0;
		if(totalsize %listsize == 0) {
			totalpage = totalpage / listsize; // 나머지가 있으면
		}else {
			totalpage = totalsize / listsize +1; // 나머지가 존재하면 나머지를 표시할 페이지 + 1
		}
		
		// 3. 현재 페이지수 
		int page = Integer.parseInt(request.getParameter("page")); 		
		// 3. 페이지별 시작 게시물 행번호
		int startrow = (page-1)*listsize;
			// 1페이지 -> (1-1) * 3 => 0 
			// 2페이지 -> (2-1) * 3 => 3
			// 3페이지 -> (3-1) * 3 => 6
			// 4페이지 -> (4-1) * 3 => 9
		
		// 3. 화면에 표시할 최대 버튼 수 
		int btnsize = 5; // 버튼 5개씩 표시 [ 몫 : 5배수 ] 
		int startbtn = ((page-1)/ btnsize ) * btnsize + 1; 
		int endbtn = startbtn + (btnsize -1) ; 
			// 만약에 endbtn 마지막 페이지보다 크면 마지막버튼 번호는 마지막 페이지 번호 
		if(endbtn> totalpage)endbtn = totalpage;
		
		// 1. 1 페이지 경우 ((1-1)/ btnsize ) * btnsize + 1         = 1
		// 2. 2 페이지 경우 ((2-1)/ btnsize ) * btnsize + 1 		 = 1
		// 3. 3 페이지 경우 ((3-1)/ btnsize ) * btnsize + 1  		 = 1
		// 4. 4 페이지 경우 ((4-1)/ btnsize ) * btnsize + 1 
		// 5. 5 페이지 경우 ((5-1)/ btnsize ) * btnsize + 1 			
		// 6. 6 페이지 경우 ((6-1)/ btnsize ) * btnsize + 1 
		
		
		
		// 		 			sb          eb
		// page 1~5 		1  2  3  4  5 
		// page 6~10		6  7  8  9  10 
		// page 11~15		11 12 13 14 15
		// page 16~20		16 17 18 19 20
		
		
		
		// 페이징처리에 필요한 정보 담는 jsonobject
		JSONObject boards = new JSONObject();
		
		// 2. db
		ArrayList<BoardDto> list =  BoardDao.getInstance().getlist(startrow,listsize);
			// ** arraylist ---> jsonarray 변환[ js에서 쓸려고 ]
			JSONArray array = new JSONArray();
			for( int i = 0  ; i<list.size() ; i++ ) {
				JSONObject object = new JSONObject();
				object.put("bno", list.get(i).getBno() );
				object.put("btitle", list.get(i).getBtitle() );
				object.put("bdate", list.get(i).getBdate() );
				object.put("bview", list.get(i).getBview() );
				object.put("mid", list.get(i).getMid() );
				array.add(object);
			}		
		// 4. 
		boards.put("totalpage", totalpage);
		boards.put("data", array);
		boards.put("startbtn", startbtn);
		boards.put("endbtn", endbtn);
			
		// 3. 응답o
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().print( boards );
		
		
		
		
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list() {
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