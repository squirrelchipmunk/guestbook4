package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestBookVo> getGuestBookList() {
		List<GuestBookVo> guestBookList = sqlSession.selectList("guestbook.selectList");
		
		return guestBookList;
	}

	public void addGuestBook(GuestBookVo vo) {
		sqlSession.insert("guestbook.insert", vo);
	}
	
	public void deleteGuestBook(GuestBookVo vo){
		sqlSession.delete("guestbook.delete", vo);
	}

	
	/*
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs= null;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "webdb";
	
	private void getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		}catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	
	private void close() {
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
	
	public void addGuestBook(GuestBookVo vo) {
		
		try {
			getConnection();

			String query ="";
			query += " insert into guestbook ";
			query += " values(seq_guestbook_no.nextval, ?, ?, ?, sysdate) " ;

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getName());    
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContent());
			
			int count = pstmt.executeUpdate();  
			System.out.println("["+count + " 건이 등록되었습니다.]");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
	}
	
	public void deleteGuestBook(GuestBookVo vo){
		try {
			getConnection();

			String query ="";
			query += " delete from guestbook ";
		    query += " where no = ? and password = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
			
			int count = pstmt.executeUpdate();
			
			System.out.println("["+count + " 건이 삭제되었습니다.]");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		

		close();
	}
	
	public List<GuestBookVo> getGuestBookList() {
		List<GuestBookVo> guestBookList = new ArrayList<>();
		
		try {
			getConnection();

			String query ="";
			query += " select no, ";
			query += " 	 	  name, ";
			query += " 		  password, ";
			query += " 		  content, ";
			query += " 		  to_char(reg_date,'yyyy-mm-dd hh24:mi:ss') reg_date";
			query += " from guestbook ";
			query += " order by reg_date desc ";
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();  
			
			while(rs.next()) { //			  
				GuestBookVo vo = new GuestBookVo( 
						rs.getInt(1), rs.getString(2), "", rs.getString(4).replace(" ", "&nbsp;").replace("\n", "<br>"), rs.getString(5) );
				guestBookList.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
			
		return guestBookList;
	}
	
	public GuestBookVo getGuestBook(int no) {
		GuestBookVo guestBook = null;
		
		try {
			getConnection();

			String query ="";
			query += " select no, ";
			query += " 	 	  name, ";
			query += " 		  password, ";
			query += " 		  content, ";
			query += " 		  reg_date ";
			query += " from guestbook ";
			query += " where no = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();  
			
			rs.next();		  
			guestBook = new GuestBookVo( 
					rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).replace(" ", "&nbsp;").replace("\n", "<br>"), rs.getString(5) );
			
			

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		
		close();
			
		return guestBook;
	}
	*/
}
