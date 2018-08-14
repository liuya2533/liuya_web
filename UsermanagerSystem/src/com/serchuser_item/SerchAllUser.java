package com.serchuser_item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.menu.SerchUserMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.utils.DBUtil2;

public class SerchAllUser implements Item {

	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
		Connection conn=DBUtil2.getInstance().getConnect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from userinfo");
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String email=rs.getString("email");
				int power=rs.getInt("power");
				System.out.println(id+"  |  "+username+"  |  " +
						password+"  |  "+email+"  |  "+
						(power==0?"普通用户":"管理员"));
				System.out.println("======================================");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil2.getInstance().close(conn);
		DBUtil2.getInstance().close(ps);
		DBUtil2.getInstance().close(rs);
		return new SerchUserMenu();
	}
}
