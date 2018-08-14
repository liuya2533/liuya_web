package com.mainmenuitem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.menu.AdminMenu;
import com.menu.MainMenu;
import com.menu.NormalMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.bean.Userinfo;
import com.nensoft.start.Start;
import com.utils.ConsoleUtil;
import com.utils.DBUtil2;

public class LoginItem implements Item{

	
	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("用户登录界面");
		System.out.println("==============");
		System.out.println("请输入你的用户名：");
		String username= ConsoleUtil.getString();
		System.out.println("请输入你的密码：");
		String password= ConsoleUtil.getString();
		Connection con=Start.db.getConnect();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement("select * from userinfo where username=?");
			ps.setString(1, username);
			ResultSet st=ps.executeQuery();
			if(st.next()){
				Userinfo userinfo=new Userinfo();
				userinfo.setId(st.getInt("id"));
				userinfo.setUsername(st.getString(2));
				userinfo.setPassword(st.getString(3));
				userinfo.setEmail(st.getString(4));
				userinfo.setPower(st.getInt(5));
				System.out.println("登录成功");
				Start.loginuser=userinfo;
				if(userinfo.getPower()== 0){
					return (Menu) new NormalMenu();
				}else{
					return (Menu) new AdminMenu();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Menu) new MainMenu();
	}

}
