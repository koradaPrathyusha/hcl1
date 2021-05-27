package com.hcl.book.servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.book.beans.Book;
import com.hcl.book.exception.UserDefinedException;
import com.hcl.book.services.BookServices;

@WebServlet("/addBook")
public class BookAddServlet extends HttpServlet{
		
		private static final long serialVersionUID = 1L;
		public void init() throws ServletException{
			System.out.println("Servlet initialised");
		}
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String price = req.getParameter("price" );
			
			Book b= new Book(); 
			b.setTitle(title);
			b.setAuthor(author);
			b.setPrice(Float.parseFloat(price));
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			BookServices.addBook(b);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("message","Added Successfully" );
			rd.include(req, res);
		}
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
		{
			doGet(req,res);
		}
		public void destroy() {
			System.out.println("servlet destroyed");
		}

	}
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.hcl.book.beans.Book;
//import com.hcl.book.exception.UserDefinedException;
//import com.hcl.book.services.BookServices;
//
//
//	
//@WebServlet(urlPatterns = {"/addBook"})
//public class BookAddServlet extends HttpServlet{
//	public BookAddServlet() {
//		System.out.println("inside constructor");
//	}
//	public void init(ServletConfig config) {
//		System.out.println("servlet init");
//	}
////	public void service(ServletRequest req,ServletResponse res) {
////		System.out.println("inside service");
////	}
//	@Override
//	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
//		System.out.println("Servlet get service");
//		
//		String title=req.getParameter("title");
//		String author=req.getParameter("author");
//		String price=req.getParameter("price");
//		Book e=new Book();
//		e.setTitle(title);
//		e.setAuthor(author);
//		e.setPrice(Float.parseFloat(price));
//		
//		
//		//PrintWriter pw=res.getWriter();
////		res.setContentType("text/html");
////		BookServices service=new BookServices();
////		try {
////			service.addBook(e);
////			pw.print("<html><body>added"+title+"</body></html>");
////		}catch(BookException r) {
////			e.printStackTrace();
////			pw.print("<html><body><p>f"+r.getMessage()+"</body></html>");
////		}
////		
//		PrintWriter pw;
//		try {
//			pw = res.getWriter();
//			pw.print("<html><body>added"+title+"</body></html>");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		res.setContentType("text/html");
//		BookServices service=new BookServices();
//		service.addBook(e);
//		
//	}
//	@Override
//	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
//		System.out.println("Servlet post service");
//		doGet(req,res);
//	}
//	
//	public void destroy() {
//		System.out.println("inside destroy");
//	}
//}
//
//
