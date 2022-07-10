package com.saeyan.dao;

import java.util.*;
import java.sql.*;
import com.seayan.dto.*;
import util.DBManager;

public class ProductDAO {
	private ProductDAO() {}
	
	
	//싱글톤 객체 생성
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}

	public List<ProductVO> selectAllProducts(){
		List<ProductVO> list = new ArrayList<ProductVO>();
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql="select *from product order by code desc";
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pvo =new ProductVO();
				pvo.setCode(rs.getInt("code"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice(rs.getInt("price"));
				pvo.setPictureurl(rs.getString("pictureUrl"));
				pvo.setDescription(rs.getString("description"));
			list.add(pvo);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.closeConnection(conn, pstmt,rs);
			}
			return list;
		}
//insert
	public int insertProduct(ProductVO pvo) {
		int result=-1;
		
			String sql="insert into product values(product_seq.nextval,?,?,?,?)";
			Connection conn=null;
			PreparedStatement pstmt =null;
			
			try {
				conn=DBManager.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, pvo.getName());
				pstmt.setInt(2, pvo.getPrice());
				pstmt.setString(3, pvo.getPictureurl());
				pstmt.setString(4, pvo.getDescription());
				
				result=pstmt.executeUpdate();
				System.out.println("result" + result);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				DBManager.closeConnection(conn, pstmt);
			}
		
		
		return result;
	}

	public ProductVO selectProductBycode(String code) {
		
		ProductVO pvo = new ProductVO();
		
		String  sql = "select *from product where code=?";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			conn=DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				pvo = new ProductVO();
				pvo.setCode(rs.getInt(1));
				pvo.setName(rs.getString(2));
				pvo.setPrice(rs.getInt(3));
				pvo.setPictureurl(rs.getString(4));
				pvo.setDescription(rs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt,rs);
		}
		return pvo;
	}

	public void updateProduct(ProductVO pvo) {
		
		
		String sql = "update product set name=?, price=?, pictureurl=?, description=? where code=?";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getName());
			pstmt.setInt(2, pvo.getPrice());
			pstmt.setString(3, pvo.getPictureurl());
			pstmt.setString(4, pvo.getDescription());
			pstmt.setInt(5, pvo.getCode());
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		
	}

	public void deleteProduct(String code) {
		String sql="delete product where code=?";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn =DBManager.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}

}