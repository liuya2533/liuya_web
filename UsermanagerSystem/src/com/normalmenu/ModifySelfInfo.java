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
		System.out.println("�����ڵ���Ϣ�ǣ�");
		System.out.println(Start.loginuser.getId()+"  |  "+Start.loginuser.getUsername()+"  |  " +
				Start.loginuser.getPassword()+"  |  "+Start.loginuser.getEmail()+"  |  "+
				(Start.loginuser.getPower()==0?"��ͨ�û�":"����Ա"));
		System.out.println("================");
		System.out.println("��������Ҫ�޸ĵ�������");
		String username=ConsoleUtil.getString();
		System.out.println("��������Ҫ�޸ĵ����룺");
		String password=ConsoleUtil.getString();
		System.out.println("��������Ҫ�޸ĵ����䣺");
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
				System.out.println("�û����ѱ�ռ�ã�  ����������...");
				username=ConsoleUtil.getString();
			}else{
				conn.setAutoCommit(false);
				ps=conn.prepareStatement("update userinfo set username=?,password=?,email=? where id="+Start.loginuser.getId());
				ps.setString(1,username);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.executeUpdate();
				conn.commit();
				Start.loginuser.setUsername(username);  //�޸������ݿ����Ϣ��Ҫͬʱ�޸��û���(UserInfo)������
				Start.loginuser.setPassword(password);
				Start.loginuser.setEmail(email);
				System.out.println("�޸ĳɹ�!");
				
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
