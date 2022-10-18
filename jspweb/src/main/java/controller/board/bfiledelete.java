package controller.board;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import model.dao.BoardDao;
import model.dto.BoardDto;

@WebServlet("/board/bfiledelete")
public class bfiledelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 삭제할 게시물 번호 = 현재 보고 있는 게시물번호 = 세션(Object -> 형변환)
		int bno = (Integer)request.getSession().getAttribute("bno");

		// 삭제할 게시물 정보 호출
		BoardDto dto = BoardDao.getInstance().getboard(bno);
		
		// 2. DAO 처리
		boolean result = BoardDao.getInstance().bfiledelete(bno);
		
		// 3. 실제 파일 삭제 처리
		if(result) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile());
			File file = new File(deletepath);
			if(file.exists()) {file.delete();}
			}
		// 4. 결과 변환
		response.getWriter().print(result);
		}
	
	private static final long serialVersionUID = 1L;
	
	public bfiledelete() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	}

	


