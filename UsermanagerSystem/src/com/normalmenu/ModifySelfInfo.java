package com.normalmenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.menu.NormalMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.utils.ConsoleUtil;
import com.utils.DBUtil2;

public class ModifySelfInfo implements Item{

	
	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("================");
		System.out.println("您现在的信息是：");
		System.out.println(Start.loginuser.getId()+"  |  "+Start.loginuser.getUsername()+"  |  " +
				Start.loginuser.getPassword()+"  |  "+Start.loginuser.getEmail()+"  |  "+
				(Start.loginuser.getPower()==0?"普通用户":"管理员"));
		System.out.println("================");
		System.out.println("请输入您要修改的姓名：");
		String username=ConsoleUtil.getString();
		System.out.println("请输入您要修改的密码：");
		String password=ConsoleUtil.getString();
		System.out.println("请输入您要修改的邮箱：");
		String email=ConsoleUtil.getString();
		Connection conn=Start.db.getConnect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=conn.prepareStatement("select * from userinfo where username=? and id!=?");
			ps.setString(1, username);
			ps.setInt(2,Start.loginuser.getId());
			rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("用户名已被占用！  请重新输入...");
				username=ConsoleUtil.getString();
			}else{
				conn.setAutoCommit(false);
				ps=conn.prepareStatement("update userinfo set username=?,password=?,email=? where id="+Start.loginuser.getId());
				ps.setString(1,username);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.executeUpdate();
				conn.commit();
				Start.loginuser.setUsername(username);  //修改完数据库的信息后还要同时修改用户类(UserInfo)的属性
				Start.loginuser.setPassword(password);
				Start.loginuser.setEmail(email);
				System.out.println("修改成功!");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Start.db.close(rs);
		Start.db.close(ps);
		Start.db.close(conn);
		return new NormalMenu();
	}

}
