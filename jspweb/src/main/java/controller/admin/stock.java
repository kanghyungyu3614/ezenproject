package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.ProductDao;
import model.dto.StockDto;

/**
 * Servlet implementation class stock
 */
@WebServlet("/admin/stock")
public class stock extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public stock() {
        super();
        // TODO Auto-generated constructor stub
    }

	// 재고 출력 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [ 제품별 모든 재고 확인 -> 제품번호 요청 ] 
		int pno = Integer.parseInt( request.getParameter("pno") ); // 제품번호
		// 2. db처리 
		ArrayList<StockDto> list = new ProductDao().getstock( pno );
		// 3. 형변환 [ list -> jsonarray ] 
		JSONArray array = new JSONArray();
		for( StockDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("psno", dto.getPsno() );		object.put("psize", dto.getPsize() );
			object.put("pstno", dto.getPstno() );	object.put("pcolor", dto.getPcolor() );
			object.put("pstock", dto.getPstock() );	array.add(object);
		}
		// 4. 반환 
		response.setCharacterEncoding("UTF-8");		response.getWriter().print(array);
	}
	// 재고 등록 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.요청
		request.setCharacterEncoding("UTF-8");
		String psize = request.getParameter("psize");	// 사이즈명
		int pno = Integer.parseInt( request.getParameter("pno") ); // 제품번호
		String pcolor = request.getParameter("pcolor");	// 색상
		int pstock = Integer.parseInt(  request.getParameter("pstock") ); // 재고 
		// 2.db처리 
		boolean result = new ProductDao().setstock(  psize ,  pno , pcolor , pstock   );
		// 3.결과
		response.getWriter().print(result);
	}


	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}