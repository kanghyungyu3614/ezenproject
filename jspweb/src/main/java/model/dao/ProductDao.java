package model.dao;

import java.util.ArrayList;

import controller.admin.pcategory;
import model.dto.PcategoryDto;
import model.dto.ProductDto;

public class ProductDao extends Dao {

	// 1. 카테고리 등록 [ C ]
	public boolean setPcategory( String pcname ) {
		String sql = "insert into pcategory(pcname) values(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pcname);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 카테고리 출력 [ R  리드는 다오부터 시작해라.]
	public ArrayList< PcategoryDto > getPcategory(){
		ArrayList<PcategoryDto> list = new ArrayList<>();
		String sql = "select * from pcategory";
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				PcategoryDto dto = new PcategoryDto(rs.getInt(1),rs.getString(2));
				list.add(dto);
			}
			
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	// 3. 제품 등록  [ C ]
	public boolean setProduct (ProductDto dto ) {
		String sql = "insert into product(pname, pcomment, pprice, pdiscount, pimg, pcno) values (?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());
			ps.setFloat(4, dto.getPdiscount());
			ps.setString(5, dto.getPimg());
			ps.setInt(6, dto.getPcno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 4. 제품 출력  [ R ]
	public ArrayList< ProductDto > getProductlist(){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select * from product";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto =  new ProductDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getFloat(5),
						rs.getByte(6),
						rs.getString(7),
						rs.getString(8),
						rs.getInt(9));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
}