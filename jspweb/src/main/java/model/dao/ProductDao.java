package model.dao;

import java.util.ArrayList;

import model.dto.PcategoryDto;
import model.dto.ProductDto;

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
}

















