package com.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.util.Properties;

public class DBUtil2 {
	private static DBUtil2 db;
	private String url;
	private String username;
	private String password;
	private String driver;
	private DBUtil2(){
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DBUtil2 getInstance(){
		if(db==null){
			db = new DBUtil2();
		}
		return db;
	}
	public Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void close(Connection item){
		if(item!=null){
			try {
				item.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void close(ResultSet item){ 
		if(item!=null){
			try {
				item.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement item){
		if(item!=null){
			try {
				item.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
