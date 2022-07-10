package util;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn =null;
		try {
			Context initContext = new InitialContext();
				Context envContext=(Context) initContext.lookup("java:/comp/env");
				//jdbc/myoracle이란 이름을 객체를 찾아서 DataSourse가 받는다
				DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
				//ds가 생성되었으므로 connection을 구합니다.
				conn =ds.getConnection();
				System.out.println("DB 연결성공!");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
	

		//select을 수행한 후 리소스 해제를 위한 메소드
		public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//insert,update,delete 작업을 수행한 후 리소스 해제를 위한 메소드
		public static void closeConnection(Connection conn, Statement stmt) {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}


	
	

