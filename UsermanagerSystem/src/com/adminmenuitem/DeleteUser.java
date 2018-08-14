package com.adminmenuitem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.menu.AdminMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.utils.ConsoleUtil;
import com.utils.DBUtil2;

public class DeleteUser implements Item{

	
	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫɾ�����û���ID");
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
		Connection conn=Start.db.getConnect();
		while(true){
		try {
			PreparedStatement ps=conn.prepareStatement("select * from userinfo where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			//��ɾ��֮ǰ�ȼ���Ƿ���ڴ�id
			if(!rs.next()){
				System.out.println("�û����ѱ�ռ��ID�����ڣ�  ����������...");
				id=scan.nextInt();
				continue;
			}else{
				conn.setAutoCommit(false);
				ps=conn.prepareStatement("delete from userinfo where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				conn.commit();
				System.out.println("ɾ���ɹ���");
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
