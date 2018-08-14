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
		System.out.println("������������");
		String username=ConsoleUtil.getString();
		System.out.println("���������룺");
		String password=ConsoleUtil.getString();
		System.out.println("���������䣺");
		String email=ConsoleUtil.getString();
		System.out.println("������Ȩ�ޣ�0.��ͨ�û�  1.����Ա");
		int power=ConsoleUtil.getOption(0,1);
		Connection conn=Start.db.getConnect();
		while(true){
		try {
			PreparedStatement ps=conn.prepareStatement("select * from userinfo where username=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("�û����ѱ�ռ�ã�  ����������...");
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
				Start.loginuser.setUsername(username);  //�޸������ݿ����Ϣ��Ҫͬʱ�޸��û���(UserInfo)������
				Start.loginuser.setPassword(password);
				Start.loginuser.setEmail(email);
				System.out.println("��ӳɹ�!");
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
