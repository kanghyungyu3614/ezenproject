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

import model.dao.BoardDao;
import model.dao.ProductDao;
import model.dto.BoardDto;
import model.dto.PcategoryDto;

/**
 * Servlet implementation class pcategory
 */
@WebServlet("/board/pcategory")
public class pcategory extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		String pcname = request.getParameter("pcname");
		System.out.println("pcname 는? "+pcname);
		// 2. dao 처리
		boolean result = new ProductDao().setPcategory(pcname);  // 싱글톤객체 사용하지 않을경우 메소드 호출방식 
		// 3. 응답
		System.out.println("result 는? "+result);
		response.getWriter().print(result);
	
	}

	
	
	private static final long serialVersionUID = 1L;
       
    public pcategory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<PcategoryDto> list = new ProductDao().getPcategory();
		JSONArray array = new JSONArray();
		for(PcategoryDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("pcno", dto.getPcno());
			object.put("pcname", dto.getPcname());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	
		
	}


}
