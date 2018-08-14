package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.portable.InputStream;

public class DBUtil {

	static Connection con=null;
	static Statement statement=null;
	static String url=null;
	static String username=null;
	static String password=null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//2.建立连接
//			String url="jdbc:mysql://127.0.0.1:3306/test";
//			String username="root";
//			String password="root";
			 try {
				 read();
				con=DriverManager.getConnection(url,username,password);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public static void read(){
//		InputStream input=(InputStream) OracleTestUtil.class.getResourceAsStream("Oracle.lib/com.oraclefile");
//		url=input.read();
		url="jdbc:mysql://127.0.0.1:3306/usermanager";
	}
	
	public static Connection getConnect(){
		System.out.println(con);
		return con;
	}

	public static void closeAll(Connection con,Statement sate){
		try {
			sate.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public  static Statement getStatement(){
		
		try {
			return statement=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}
	
		
}
