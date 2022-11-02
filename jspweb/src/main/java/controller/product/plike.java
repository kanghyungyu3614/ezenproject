package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCrud.ColumnOrBuilder;

import model.dao.MemberDao;
import model.dao.ProductDao;

/**
 * Servlet implementation class plike
 */
@WebServlet("/product/plike")
public class plike extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public plike() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		int pno = Integer.parseInt(request.getParameter("pno")); 
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		
		// 2. db처리
		int result = new ProductDao().setPlike(pno,mno);
		// 3. 응답
		response.getWriter().print(result); // true : 등록 false : 취소
	}

}
