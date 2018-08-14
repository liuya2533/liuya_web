package com.adminmenuitem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.menu.AdminMenu;
import com.menu.NormalMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.utils.ConsoleUtil;

public class ModifyUser implements Item{

	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("================");
		System.out.println("������Ҫ�޸��û���ID��");
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
		
		Connection conn=Start.db.getConnect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		while(true){
		try {
			ps=conn.prepareStatement("select * from userinfo where id=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(!rs.next()){
				System.out.println("�����ڴ��û���  ����������...");
				id=scan.nextInt();
				continue;
			}else{
				System.out.println("��ǰ���û�����Ϣ�ǣ�");
				System.out.println(rs.getInt("id")+"  |  "+rs.getString("username")+"  |  " +
						rs.getString("password")+"  |  "+rs.getString("email")+"  |  "+
						(rs.getInt("power")==0?"��ͨ�û�":"����Ա"));
				System.out.println("================");
				System.out.println("��������Ҫ�޸Ĵ��û���������");
				String username=ConsoleUtil.getString();
				System.out.println("��������Ҫ�޸Ĵ��û������룺");
				String password=ConsoleUtil.getString();
				System.out.println("��������Ҫ�޸Ĵ��û������䣺");
				String email=ConsoleUtil.getEmail();
				System.out.println("������Ȩ�ޣ�0.��ͨ�û�  1.����Ա");
				int power=ConsoleUtil.getOption(0,1);
				conn.setAutoCommit(false);
				ps=conn.prepareStatement("update userinfo set username=?,password=?,email=?,power=? where id="+id);
				ps.setString(1,username);
				ps.setString(2, password);
				ps.setString(3, email);
				ps.setInt(4, power);
				ps.executeUpdate();
				conn.commit();
				System.out.println("�޸ĳɹ���");
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Start.db.close(rs);
		Start.db.close(ps);
		Start.db.close(conn);
		}
		return new AdminMenu();
	}

}
