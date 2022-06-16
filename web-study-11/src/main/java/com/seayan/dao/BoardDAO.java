package com.seayan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {

	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {

		String sql = "select * from board order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				
				bvo.setNum(rs.getInt("num"));
				bvo.setName(rs.getString("name"));
				bvo.setEmail(rs.getString("email"));
				bvo.setPass(rs.getString("pass"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setReadcount(rs.getInt("readcount"));
				bvo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(bvo);
			}	
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.closeConnection(conn, stmt,rs);
			}
		
		
		
		return list;
	}

	public void insertBoard(BoardVO bvo) {
		String sql ="insert into board(num,name,email,pass,title,content)" +
				 "values(board_seq.nextval,?,?,?,?,?)";
	
	Connection conn =null;
	PreparedStatement pstmt = null;
	
	try {
		
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1,bvo.getName());
		pstmt.setString(2,bvo.getEmail());
		pstmt.setString(3,bvo.getPass());
		pstmt.setString(4,bvo.getTitle());
		pstmt.setString(5,bvo.getContent());
		
		pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace(); 
			
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	}

	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount+1 where num=?";
		
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace(); 
				
			}finally {
				DBManager.closeConnection(conn, pstmt);
			}
		}

	public BoardVO selectOneBoardByNum(String num) {
		
		BoardVO bvo = new BoardVO();

	      String sql = "select * from board where num=?";
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, Integer.parseInt(num));
	         rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	            bvo.setNum(rs.getInt(1));
	            bvo.setPass(rs.getString(2));
	            bvo.setName(rs.getString(3));
	            bvo.setEmail(rs.getString(4));
	            bvo.setTitle(rs.getString(5));
	            bvo.setContent(rs.getString(6));
	            bvo.setReadcount(rs.getInt(7));
	            bvo.setWritedate(rs.getTimestamp(8));
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.closeConnection(conn, pstmt, rs);
	      }
	      return bvo;

	   }

	public void updateBoard(BoardVO bvo) {
		
		String sql = "update board set name=?, email=?, pass=?," + "title=?, content=? where num = ?";
		Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	    	  conn=DBManager.getConnection();
	    	  
	    	  pstmt =conn.prepareStatement(sql);
	    	  
	    	  pstmt.setString(1, bvo.getName());
	    	  pstmt.setString(2, bvo.getEmail());
	    	  pstmt.setString(3, bvo.getPass());
	    	  pstmt.setString(4, bvo.getTitle());
	    	  pstmt.setString(5, bvo.getContent());
	    	  pstmt.setInt(6, bvo.getNum());
	    	  
	    	  pstmt.executeUpdate();
	    	  
	      }catch(Exception e){
	    	  e.printStackTrace();
	      }finally {
	    	  DBManager.closeConnection(conn, pstmt);
	      }
}
	

	public void deleteBoard(String num) {
		String sql ="delete board where num=?";
		
		Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {	
	    	  conn=DBManager.getConnection();
	    	  pstmt =conn.prepareStatement(sql);
	    	  
	    	  pstmt.setString(1, num);
	    	  pstmt.executeUpdate();
	    	  
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
		
	}

	}
	