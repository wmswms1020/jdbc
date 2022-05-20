package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {
		
		
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //변수처리
			conn = DriverManager.getConnection(url, "webdb", "webdb"); //url을 변수처리해서 넣음(너무길어서)
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    //SQL문 준비
			String query = "";
			
			query += " insert into author ";
			query += " values(seq_author_id.nextval, ? , ? ) ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query); 	//문자열 쿼리로 만들기
			pstmt.setString(1, "이문열");				//?(물음표)중 1번째 -->순서중요
			pstmt.setString(2, "경북 영양");			//?(물음표)중 2번째 -->순서중요
			
			//실행
			int count = pstmt.executeUpdate();					//쿼리문 실행 -->성공갯수 리턴
			
		    // 4.결과처리
			System.out.println(count+"건이 등록 되었습니다.");
			
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		    	/*
		        if (rs != null) {
		            rs.close();
		        }
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

	}

}
