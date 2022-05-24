package com.javaex.ex04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/************************
**Dao(Data Access Object)
**DataBase(오라클) 관련 일을 하는 클래스
************************/


public class AuthorDao {
	//필드
	
	
	//생성자ㅣ
	
	
	//메소드 gs
	
	
	//메소드 일바
	
	public void authorInsert(AuthorVo authorVo) {
		
		
		
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

		    // 3. SQL문 준비 / 바인딩 / 실행
		    
			//SQL문 준비
			String query = "";
			query += " insert into author ";
			query += " values(seq_author_id.nextval, ? , ? ) ";	
			System.out.println(query);
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorVo.getAuthorName());
			pstmt.setString(2, authorVo.getAuthorDesc());
			
			
			//실행
			int count = pstmt.executeUpdate();
			
		    // 4.결과처리
			
			System.out.println(count+ "건이 등록되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        
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
	//--작가 삭제 메소드
	public int authorDelete(int authorId) {
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
			query += " delete from author ";
			query += " where author_id = ? ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, authorId);
			
			//실행
			count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count+"건 삭제 되었습니다.");
			
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
	
	//--작가 수정 메소드
	public int authorUpdate(int authorID, String authorName, String authorDesc) {
		
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
			query += " update author ";
			query += " set author_name = ?, ";
			query += " 	   author_desc = ? ";
			query += " where author_id = ? ";
			System.out.println(query);
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, authorName);
			pstmt.setString(2, authorDesc);
			pstmt.setInt(3, authorID);
			
			//실행
			count = pstmt.executeUpdate();
			
			
		    // 4.결과처리
			System.out.println(count +"건이 수정되었습니다.");
			
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
	//--작가 전체리스트 가져오기
	public List<AuthorVo> authorSelect() {
		
		//리스트 준비
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();
		
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
		    //SQL문 준비
			String query = "";
			query += " select  author_id, ";
			query += "		   author_name,";
			query += " 		   author_desc ";
			query += " from author ";
			
			System.out.println(query);
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			//실행
			//ResultSet 가져오기
			rs = pstmt.executeQuery();
			
		    // 4.결과처리
			
			
			
			//반복문으로 Vo 만들고 List에 추가하기
			while(rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				AuthorVo authorVo = new AuthorVo(authorId, authorName, authorDesc);
				
				authorList.add(authorVo);
			}
			
			//리스트를 출력해보기
			//테스트용 투스트링
			//System.out.println(authorList.toString());
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
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
		return authorList;
	}
	
	
}
