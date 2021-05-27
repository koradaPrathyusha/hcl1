package com.hcl.book.util; 


import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    static String url = "jdbc:mysql://localhost:3306/library";
    static String userName = "root";
    static String password = "2618";
    private static Connection con = null;
    private DBConnection() {
    }
    public static Connection getConnection() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (con == null) {
            try {
                //com.mysql.cj.jdbc.Driver d = null;
                com.mysql.jdbc.Driver d=null;
                try {
                    d = new com.mysql.jdbc.Driver();
                } catch (Exception e) {
                    System.out.println("ERROR BY NEW DRIVER " + e.toString() + "\n");
                    e.printStackTrace();
                }
                con = DriverManager.getConnection(url, userName, password);

 

            } catch (java.sql.SQLException ex) {
                System.out.println("ERROR IN makeStatement ");
            }
        }
        return con;

 

    }
}


//
//	import java.sql.Connection;
//	import java.sql.DriverManager;
//	import java.sql.SQLException;
//
//	public class DBConnection {
//		
//		private final static String url="jdbc:mysql://localhost:3306/library";
//		private final static String username="root";
//		private final static String password="2618";
//		
//		private DBConnection () {
//			
//		}
//		private static Connection con=null;
//		public static Connection getConnection() {
//			//Connection con =null;
//			try {
//				if(con==null)
//				con=DriverManager.getConnection(url,username,password);
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//			return con;
//			
//		}
//
//	}
//
//
//
//
