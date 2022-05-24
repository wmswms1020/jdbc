package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {

	//필드
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	
	public int bookInsert(String bookTitle, String bookPubs,String bookDate, String authorName) {
		
		int count = -1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    //SQL문 준비
			String query = "";
			query = " insert into book ";
			query = " values(seq_book_id.nextval, ? , ? , ? , ?) ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bookTitle);
			pstmt.setString(2, bookPubs);
			pstmt.setString(3, bookDate);
			pstmt.setString(4, authorName);
			
			System.out.println(query);
			
			//실행
			
			count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count+"건이 등록되었습니다.");
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
				/*
				 * if (rs != null) { rs.close(); }
				 */            
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }
		    
		}
		return count;
		
	}
	
	
	
}
