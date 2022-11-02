package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.ProductDao;
import model.dto.ProductDto;

/**
 * Servlet implementation class regist
 */
@WebServlet("/admin/regist")
public class regist extends HttpServlet { // HttpServlet 서블릿클래스[ http 메소드 구현 ]
	
	///////////////////////////////////// 1. 제품 등록 메소드 [ post 매핑 ] ///////////////////////////////////////////////////
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 첨부파일이 있을경우 [ 업로드 용 ] */
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getSession().getServletContext().getRealPath("/admin/pimg") , 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );
		
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");	
		int pprice = Integer.parseInt( multi.getParameter("pprice") ) ;		
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		String pimg = multi.getFilesystemName("pimg"); 
		
		int pcno = Integer.parseInt( multi.getParameter("pcno") );
		
		ProductDto dto = new ProductDto( 0 , pname, pcomment,pprice, pdiscount, (byte) 0 ,pimg, null, pcno );
		
		boolean result = new ProductDao().setProduct(dto);
		response.getWriter().print(result);
	}
	
	//////////////////////////////////////////// 2. 제품 출력 메소드 [ get 매핑 ]  ////////////////////////////////////////////////
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 타입 : 1 [ 모든 제품 출력 ]  2 [ 개별 제품 출력 ] 
		// 공통 변수
		String type = request.getParameter("type");
		response.setCharacterEncoding("UTF-8");
		if( type.equals("1") ) {
			
			// 1.전체출력 2.판매중 출력
			String option = request.getParameter("option");
			
			//////////////////////////////////////////// 모든 제품 출력 //////////////////////////
			ArrayList<ProductDto> list  = new ProductDao().getProductlist( option );// DAO 처리 
			JSONArray array = new JSONArray(); 	// LIST -> JSON
			for( int i = 0 ; i<list.size() ; i++ ) {
				JSONObject object  = new JSONObject();
				object.put("pno", list.get(i).getPno() );				
				object.put("pname", list.get(i).getPname() );
				object.put("pcomment", list.get(i).getPcomment() );		
				object.put("pprice", list.get(i).getPprice() );
				object.put("pdiscount", list.get(i).getPdiscount() );	
				object.put("pactive", list.get(i).getPactive() );
				object.put("pimg", list.get(i).getPimg() );				
				object.put("pdate", list.get(i).getPdate() );
				object.put("pcno", list.get(i).getPcno() );			
				array.add(object);
			}
			response.getWriter().print(array);
			///////////////////////////////////////////////////////////////////////////////////
			
		}else if( type.equals("2") ) {
			////////////////////////////////////////////  개별 제품 출력 //////////////////////////
			// 1. 호출할 제품번호 요청 
			int pno = Integer.parseInt( request.getParameter("pno") ) ;
			// 2. db처리 
			ProductDto dto = new ProductDao().getpProduct( pno );
			// 3. dto -> json 형변환 [ 로직 ] 
				JSONObject object  = new JSONObject();
				object.put("pno", dto.getPno() );				
				object.put("pname", dto.getPname() );
				object.put("pcomment", dto.getPcomment() );		
				object.put("pprice", dto.getPprice() );
				object.put("pdiscount", dto.getPdiscount() );	
				object.put("pactive",dto.getPactive() );
				object.put("pimg", dto.getPimg() );				
				object.put("pdate", dto.getPdate() );
				object.put("pcno", dto.getPcno() );	
			// 4. 응답 
			response.getWriter().print(object);
			///////////////////////////////////////////////////////////////////////////////////
		}
		

	}
	
	/////////////////////////////////////////// 3. 제품 수정 메소드 [ put 매핑 ]  ///////////////////////////////////////////////
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 첨부파일이 있을경우 [ 업로드 용 ] */
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getSession().getServletContext().getRealPath("/admin/pimg") , 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );
		
		int pno = Integer.parseInt( multi.getParameter("pno") );	// 수정할 대상 
		byte pactive = Byte.parseByte(multi.getParameter("pactive")); // 제품상태
		
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");	
		int pprice = Integer.parseInt( multi.getParameter("pprice") ) ;		
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		String pimg = multi.getFilesystemName("pimg"); 
		
		int pcno = Integer.parseInt( multi.getParameter("pcno") );	// 수정할 대상 
		
		// 과제
		// * 기존첨부파일 변경 여부 판단 
		boolean bfilechange = true;
		ProductDto olddto = new ProductDao().getpProduct( pno );
		
		 // *. 수정시 첨부파일 등록 없을경우 [ 기존첨부파일 호출  ]
		if( pimg == null ) {  pimg = olddto.getPimg(); bfilechange =false; }
		
		ProductDto dto = new ProductDto( pno , pname, pcomment,pprice, pdiscount, pactive ,pimg, null, pcno );

		boolean result = new ProductDao().updateProduct(dto);
		
		// 4.dao 처리 [ 업데이트 = 새로운 첨부파일 ]
		if( result && bfilechange ) {  deletefile( request.getSession() , olddto.getPimg() ); }
		
		response.getWriter().print(result);
		
	}
	
	//////////////////////////////////////////  4. 제품 삭제 메소드 [ delete 매핑 ]  //////////////////////////////////////////////
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.  삭제할 제품번호 요청 
		int pno = Integer.parseInt( request.getParameter("pno") );
		ProductDto olddto = new ProductDao().getpProduct( pno );
		// 2. dao 
		boolean result =  new ProductDao().deleteprodcut( pno );
		if( result ) { deletefile( request.getSession() , olddto.getPimg() ); }
		// 3. 응답 
		response.getWriter().print(result);
	}
	
	////////////////////////////////////////// 5. 수정 및 삭제시 첨부파일 제거 메소드 [ file delete ]  //////////////////////////////////////////////
	public void deletefile( HttpSession session ,  String pimg ) {
		String deletepath = session.getServletContext().getRealPath("/admin/pimg/"+ pimg );
		File file = new File( deletepath );
		if( file.exists() ) file.delete();	// 해당 경로에 존재하는 파일을 삭제
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

    public regist() {
        super();
        // TODO Auto-generated constructor stub
    }

}