package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.CartDto;

/**
 * Servlet implementation class cart
 */
@WebServlet("/product/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 요청
		int mno = MemberDao.getInstance().getMno(
				(String)request.getSession()
				.getAttribute("mid") ) ;
		// 2. db처리
		ArrayList<CartDto> list = 
				new ProductDao().getCart(mno);
		
		JSONArray array = new JSONArray();
		// * 형변환
		for( CartDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put( "cartno" , dto.getCartno());
			object.put( "pstno" , dto.getPstno());
			object.put( "pname" , dto.getPname());
			object.put( "pimg" , dto.getPimg());
			object.put( "pprice" , dto.getPprice());
			object.put( "pdiscount" , dto.getPdiscount());
			object.put( "pcolor" , dto.getPcolor());
			object.put( "psize" , dto.getPsize());
			object.put( "amount" , dto.getAmount());
			array.add( object );
		}
		// 3. 응답 
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( array );
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.요청
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data");
		int pno = Integer.parseInt( request.getParameter("pno") );	
		int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("mid") );
			
		// 문자열 ---> JSON 형 변환
		try {
			JSONParser parser = new JSONParser();  // 1.JSONParser parser객체생성 
			JSONArray array = (JSONArray)parser.parse( data );   // 2. parser.parse( "문자열" ) 
			
			for( int i = 0 ; i<array.size() ; i++  ) { // 3. 반복문
				JSONObject object = (JSONObject) array.get(i); // 4.순서대로 객체 꺼내기 // json리스트객체.get(인덱스) => 해당 인덱스의 객체
				
				System.out.println( object );
				// 2.db처리 	// json객체.get("키") => 값 호출  // !! : 재고번호
				String psize 	= (String)object.get("psize");	System.out.println( psize );
				int amount 	= Integer.parseInt( String.valueOf( object.get("amount" ) ) );	System.out.println( amount );
				String pcolor 	= (String)object.get("pcolor");	System.out.println( pcolor );
				
				boolean result = new ProductDao().setcart( pno , psize  , amount , pcolor , mno  );
				
				// 3.응답 [ 만약에 옵션들을 중에 하나라도 실패하면 false 반환 ] 
				if( result == false ) { response.getWriter().print(result); return; }
			}
			
		}catch (Exception e) {System.out.println("json으로 변환 실패:"+e);}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("true"); // 옵션들을 모두 저장했을경우 
	}

}

/*
 								
 	JSON 						강제형변환[ 부모가 자식 ]
 		"문자" : 문자열 String		(String) ----> O 	[ 클래스가 동일하니까 ]		
 		숫자 : Long				(String) ----> x    메소드 이용 [ String.valueOf( ) ]
 
 */



















