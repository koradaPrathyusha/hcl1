package com.hcl.book.services;

import java.util.ArrayList;
import java.util.List;

import com.hcl.book.beans.Book;
import com.hcl.book.exception.UserDefinedException;
import com.hcl.book.repository.BookDAO;

public class BookServices {
	//EmployeeDAO ed= new EmployeeDAO();
	
	public static ArrayList<Book> displayBook(){
		return BookDAO.displayBook(); 
	}

	public static Book addBook(Book e) {
		// TODO Auto-generated method stub
		try {
			return BookDAO.addBook(e);
		} catch (UserDefinedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	public static void  deleteBook(Book book) {
		// TODO Auto-generated method stub
		 try {
			BookDAO.deleteBook(book);
		} catch (UserDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateBook(Book book) {
		// TODO Auto-generated method stub
		try {
			BookDAO.updateBook(book);
		} catch (UserDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	

	
}
