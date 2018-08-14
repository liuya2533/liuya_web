package com.mainmenuitem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.menu.MainMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.utils.ConsoleUtil;
import com.utils.DBUtil;
import com.utils.DBUtil2;

public class RegItem implements Item{

	
	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("用户注册界面");
		System.out.println("==========");
		System.out.println("请输入你的用户名");
		String username=ConsoleUtil.getString();
		System.out.println("请输入你的密码：");
		String password = ConsoleUtil.getString();
		System.out.println("请输入你的邮箱：");
		String email= ConsoleUtil.getEmail();
		Connection con=Start.db.getConnect();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement("select * from userinfo where username=?");
			ps.setString(1, username);
			ResultSet st=ps.executeQuery();
			if(st.next()){
				System.out.println(st);
				System.out.println("此用户已被占用");
			}else{
				ps=con.prepareStatement("insert into userinfo(username,password,email) values(?,?,?)");
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.executeUpdate();
				con.setAutoCommit(true);
				System.out.println("注册成功!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MainMenu();
	}

}
