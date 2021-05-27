package com.hcl.book.repository;

import java.sql.*;

import java.util.*;

import com.hcl.book.beans.Book;
//import com.hcl.jdbcemployee.exception.IDException;
import com.hcl.book.exception.UserDefinedException;
import com.hcl.book.util.DBConnection;

public class BookDAO {
	
	public static  Book addBook(Book book) throws UserDefinedException{
		 Connection con= DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		try {
// inserting values
			
			String sql2="insert into Book values(?,?,?)";
			pstmt=con.prepareStatement(sql2);
			
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setFloat(3, book.getPrice());
			pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			//closePreparedStatement(pstmt);
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}
//dispaly details
	//public void addEmployee() {
	public static ArrayList<Book> displayBook(){
		ArrayList<Book> book= new ArrayList<Book>();
		Connection con= DBConnection.getConnection();
		//PreparedStatement ps=null;
		ResultSet rs=null;
		Statement stmt=null;
		
		
		 
		try {
			  stmt=con.createStatement();
			
			
			String sql1="select title,author,price from book";
			rs=stmt.executeQuery(sql1);
			
			while(rs.next()) {
				
				String title=rs.getString(1);
				String author=rs.getString(2);
				float price=rs.getInt(3);
				Book e= new Book();
				e.setTitle(title);
				e.setAuthor(author);
				e.setPrice(price);
				book.add(e);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			//stmt.close();
			rs.close();
			//closePreparedStatement(pstmt);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return book;
	}

//delete details
	public static void deleteBook(Book book) throws UserDefinedException{
		// TODO Auto-generated method stub
		Connection con= DBConnection.getConnection();
		PreparedStatement ps=null;
		try {
			
		String sql3="delete from book where title=?";
		ps=con.prepareStatement(sql3);
		ps.setString(1,book.getTitle());
		ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
//update details
	public static void updateBook(Book book) throws UserDefinedException{
		// TODO Auto-generated method stub
		Connection con= DBConnection.getConnection();
		PreparedStatement pst=null;
		try {
			
			String sql4="update book set author=? where title=?";
			pst=con.prepareStatement(sql4);
			pst.setString(1, book.getAuthor());
			pst.setString(2, book.getTitle());
			pst.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
//	public static boolean searchById(int emp1id) {
//		PreparedStatement ps1=null;
//		ResultSet rs=null;
//		Connection con= DBConnection.getConnection();
//		try {
//			String sql5="select count(*) from employee where emp1id=?";
//			ps1=con.prepareStatement(sql5);
//			ps1.setInt(1,emp1id);
//			rs=ps1.executeQuery();
//			int count=0;
//			while(rs.next()) {
//				count=rs.getInt(1);
//			}
//			if(count==0)
//				return false;
//			else 
//				return true;
//			
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//		
//	}
	
}
	



