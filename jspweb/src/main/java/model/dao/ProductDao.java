package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import controller.admin.regist;
import model.dto.CartDto;
import model.dto.OrderDto;
import model.dto.PcategoryDto;
import model.dto.ProductDto;
import model.dto.StockDto;

public class ProductDao extends Dao {

	// 1. 카테고리 등록 [ C ]
	public boolean setPcategory( String pcname ) {
		String sql = "insert into pcategory(pcname) values(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , pcname );
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println(e);	}
		return false;
	}
	// 2. 카테고리 출력 [ R ]
	public ArrayList< PcategoryDto > getPcategory(){
		ArrayList<PcategoryDto> list = new ArrayList<>();
		String sql = "select * from pcategory"; 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				PcategoryDto dto 
					= new PcategoryDto( rs.getInt(1) , 
							rs.getString(2) );
				list.add(dto);
			}
		}catch (Exception e) { System.out.println(e);	}
		return list;
	}
	// 3. 제품 등록  [ C ]
	public boolean setProduct (ProductDto dto ) {
		
		String sql = "insert into product( pname , pcomment , pprice , pdiscount , pimg , pcno) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getPname());	ps.setString( 2 , dto.getPcomment());
			ps.setInt( 3 , dto.getPprice());	ps.setFloat( 4 , dto.getPdiscount());
			ps.setString( 5 , dto.getPimg());	ps.setInt( 6 , dto.getPcno());
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println(e);	} return false;
		
	}
	// 4. 제품 출력  [ R ]
	public ArrayList< ProductDto > getProductlist( String option ){
		
		ArrayList< ProductDto > list = new ArrayList<>();
		String sql = null;
		if( option.equals("all") ) { // 1. 조건없는 모든 제품 출력 
			 sql = "select * from product";
		}else if( option.equals("pactive1")) { // 2. [ 판매중 ] 상태 만 모든 제품 출력 
			 sql = "select * from product where pactive = 1 order by pdate desc";
		}

				
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // 여러개 --> while -> next() 여러 번실행
				ProductDto dto = new ProductDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), 
						rs.getFloat(5), rs.getByte(6), 
						rs.getString(7), rs.getString(8), rs.getInt(9) );
				list.add(dto);
			}
		}catch (Exception e) { System.out.println( e ); }
		return list;
	}
	
	// 5. 제품 삭제 
	public boolean deleteprodcut( int pno ) {
		String sql = "delete from product "
				+ "where pno = "+pno;
		try {
			ps = con.prepareStatement(sql);
			// 삭제시 삭제된 레코드수로 삭제성공 유무판단
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 6. 제품 개별출력 
	public ProductDto getpProduct( int pno ) {
		String sql = "select * from product where pno = "+pno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) { // 1개 --> if -> next() 1번실행
				ProductDto dto = new ProductDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), 
						rs.getFloat(5), rs.getByte(6), 
						rs.getString(7), rs.getString(8), rs.getInt(9) );
				return dto;
			}
		}catch (Exception e) {System.out.println(e);} return null;
	}
	
	// 7. 제품 업데이트 
	public boolean updateProduct( ProductDto dto ) {
		String sql = "update product set pname = ? , pcomment=? , pprice=? , pdiscount=? , pactive=? , pimg=? , pcno=? "
				+ "where pno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getPname());	ps.setString( 2 , dto.getPcomment());
			ps.setInt( 3 , dto.getPprice());	ps.setFloat( 4 , dto.getPdiscount());
			ps.setByte( 5 , dto.getPactive());	ps.setString( 6 , dto.getPimg());
			ps.setInt( 7 , dto.getPcno());		ps.setInt( 8 , dto.getPno());
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println(e);	} return false;
	}
	
	// 8. 재고 등록 
	public boolean setstock( String psize ,  int pno , String pcolor , int pstock  ) {
		// 1. 사이즈 등록 
		String sql = "insert into productsize( psize , pno ) values(?,?)";
		try {
			ps = con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS );
			ps.setString( 1 , psize ); 		ps.setInt( 2 , pno );
			ps.executeUpdate();	
			rs = ps.getGeneratedKeys();
			if( rs.next() ) {
				int psno = rs.getInt(1); // pk 호출
				// 2. 색상재고 등록
				sql ="insert into productstock(  pcolor ,  pstock , psno ) "
						+ "values( ? , ? , ?) ";
				ps = con.prepareStatement(sql);
				ps.setString( 1 , pcolor );
				ps.setInt( 2 , pstock );
				ps.setInt( 3 , psno );	// 첫번째 sql 실행 결과로 생성된 pk 값 
				ps.executeUpdate();	return true;
			}
		}catch (Exception e) { System.out.println(e);	} return false;
	}
	// 9. 제품별 재고 출력 
	public ArrayList<StockDto> getstock( int pno){
		
		ArrayList<StockDto> list = new ArrayList<>();
		
		String sql = "select ps.psno , ps.psize , pst.pstno , pst.pcolor , pst.pstock "
				+ " from productsize ps , productstock pst"
				+ " where ps.psno = pst.psno and ps.pno = "+pno
				+ " order by ps.psize desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				StockDto dto = new StockDto(
						rs.getInt(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), rs.getInt(5));
				list.add(dto);
			}
		}catch (Exception e) { System.out.println(e);	} return list;
	}
	
	// 10. 제품 찜하기 
	public int setPlike( int pno , int mno ) {
		String sql = "select * from plike where pno = ? and mno = ?"; // 검색 [ 해당 찜하기 여부 있는지 체크 ]
		try {
			ps = con.prepareStatement(sql);
			ps.setInt( 1 , pno ); ps.setInt( 2 , mno ); 
			rs = ps.executeQuery();
			
			if( rs.next() ) { // 이미 찜하기가 되어 있는 경우  // 검색 결과가 있으면 => 취소  
				sql = "delete from plike where pno = ? and mno = ?";
				ps = con.prepareStatement(sql);
				ps.setInt( 1 , pno ); ps.setInt( 2 , mno ); 
				ps.executeUpdate();	return 1;
				
			}else { // 찜하기가 없는 경우  // 검색 결과가 없으면  => 등록 
				sql = "insert into plike (pno , mno) values( ? , ? ) ";
				ps = con.prepareStatement(sql);
				ps.setInt( 1 , pno ); ps.setInt( 2 , mno ); 
				ps.executeUpdate(); return 2;
			}
		}catch (Exception e) {System.out.println(e);} return 3;
	}
	
	// 11. 장바구니에 선택한 제품 옵션 저장 
	public boolean setcart( int pno , String psize ,  int amount , String pcolor , int mno) {
		
		// ! 만약에 동일한 제품 옵션 존재했을때 수량만 증가하는 업데이트 처리 [ 미구현 ]
		
		// 동일한 제품 옵션이 없을떄 
	    String sql = " insert into cart( amount , pstno , mno )"
	    		+ " values (  "
	    		+ "	"+amount+" ,"
	    		+ "    (select pstno "
	    		+ "	from productstock pst , (select psno from productsize where pno = "+pno+" and psize = '"+psize+"') sub"
	    		+ "	where pst.psno = sub.psno and pcolor = '"+pcolor+"') ,"
	    		+ "  "+mno+""
	    		+ " );";
	    
	    try {
	    	ps = con.prepareStatement(sql); ps.executeUpdate(); return true;
	    }catch (Exception e) { System.out.println( e ); } return false;
	}
	
	// 12. 회원번호의 모든 장바구니 호출 
	public ArrayList<CartDto> getCart( int mno ){
		ArrayList<CartDto> list = new ArrayList<>();
		String sql = "select "
				+ "	   c.cartno ,  c.pstno , "
				+ "    p.pname , p.pimg  , "
				+ "    p.pprice   ,   p.pdiscount  , "
				+ "	   pst.pcolor  , ps.psize  , "
				+ "    c.amount  "
				+ " from "
				+ "	   cart c natural join "
				+ "    productstock pst natural join "
				+ "    productsize ps natural join "
				+ "    product p "
				+ " where "
				+ "	c.mno = "+mno;
		try {
			ps = con.prepareStatement(sql); 
			rs = ps.executeQuery();
			while( rs.next() ) {
				CartDto cartDto = new CartDto(
						rs.getInt(1), rs.getInt(2), 
						rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getFloat(6), 
						rs.getString(7), rs.getString(8), rs.getInt(9));
				list.add(cartDto);
			}
		}catch (Exception e) {System.out.println(e);} return list;
	}
	
	// 13. 
	public boolean setOrder(ArrayList<OrderDto> list) {
		// 과제 
		// 1. 주문 레코드 생성
		//		private int ono;
		//		private String oname;
		//	    private String ophone;
		//	    private String oddress;
		//	    private String oquest;
		//	    private String odate;
		//	    private int mno;
		//	    private int odno;
		//	    private int odamount;
		//	    private int odprice;
		//	    private int odactive;
		//	    private int pstno; 
		System.out.println("ProductDao.java 파일안에 있어요.");
		System.out.println("여기 list 있어요.");
		System.out.println(list);
		System.out.println("list.get(0).getOname()");
		System.out.println(list.get(0).getOname());
		System.out.println("list.get(0)에는 무엇이 있나요?");
		System.out.println(list.get(0)); 
		//0, oname, ophone, oddress, oquest,null,  /// mno, ////  0, odamount, odprice, 0 , pstno);
		for(int i=0; i<list.size(); i++) {
			String sql = "insert into porder( oname , ophone , oddress , oquest, mno) values (?,?,?,?,?)";
			try {
				ps = con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ); //pk -fk값 때문에 필요
				ps.setString(1, list.get(i).getOname());
				ps.setString(2,list.get(i).getOphone());
				ps.setString(3,list.get(i).getOddress());
				ps.setString(4,list.get(i).getOquest());
				ps.setInt(5,list.get(i).getMno());
				ps.executeUpdate(); 
				rs = ps.getGeneratedKeys(); // executeUpdate 한후 rs에 값 넣기 
				
				while(rs.next()) {
					try {
						String sql2 = "insert into porderdetail( odamount , odprice , pstno , odno ,ono) values (?,?,?,?,?)";
						int ono = rs.getInt(1); // pk 호출
						ps = con.prepareStatement(sql2);
						ps.setInt(1,list.get(i).getOdamount());
						ps.setInt(2,list.get(i).getOdprice());
						ps.setInt(3,list.get(i).getPstno());
						ps.setInt(4,list.get(i).getOdno());
						ps.setInt(5,ono);
						ps.executeUpdate(); 
						continue;	
					} catch (Exception e) { System.out.println(e);return false;} 
				}
			}catch (Exception e) { System.out.println(e);return false;} 	
		
		
		
		}
		return true;
		
		
		
		
		
		
		
		
		// 2. 위에서 생성된 주문번호를 이용해서 주문[list] 개수 만큼 주문상세 레코드 생성
		//return false;
	}
	
	
}


// * 해당 sql에서 insert 된 pk값 가져오기
	// 1. con.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS )
		// !: Statement [ java.sql 패키지 ]
	// 2. ps.getGeneratedKeys() : pk값 호출 
















