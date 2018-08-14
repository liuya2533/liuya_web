package com.adminmenuitem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.menu.AdminMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.utils.ConsoleUtil;
import com.utils.DBUtil2;

public class AddUser implements Item{

	
	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("================");
		System.out.println("请输入姓名：");
		String username=ConsoleUtil.getString();
		System.out.println("请输入密码：");
		String password=ConsoleUtil.getString();
		System.out.println("请输入邮箱：");
		String email=ConsoleUtil.getString();
		System.out.println("请设置权限：0.普通用户  1.管理员");
		int power=ConsoleUtil.getOption(0,1);
		Connection conn=Start.db.getConnect();
		while(true){
		try {
			PreparedStatement ps=conn.prepareStatement("select * from userinfo where username=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("用户名已被占用！  请重新输入...");
				username=ConsoleUtil.getString();
				continue;
			}else{
				conn.setAutoCommit(false);
				ps=conn.prepareStatement("insert into userinfo(username,password,email,power) values(?,?,?,?)");
				ps.setString(1,username);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.setInt(4, power);
				ps.executeUpdate();
				conn.commit();
				Start.loginuser.setUsername(username);  //修改完数据库的信息后还要同时修改用户类(UserInfo)的属性
				Start.loginuser.setPassword(password);
				Start.loginuser.setEmail(email);
				System.out.println("添加成功!");
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return new AdminMenu();
	}

}
