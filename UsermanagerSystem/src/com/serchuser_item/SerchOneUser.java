package com.serchuser_item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.menu.AdminMenu;
import com.menu.SerchUserMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;

public class SerchOneUser implements Item {

	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫ��ѯ���û���ID");
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
				System.out.println(rs.getInt("id")+"  |  "+rs.getString("username")+"  |  " +
						rs.getString("password")+"  |  "+rs.getString("email")+"  |  "+
						(rs.getInt("power")==0?"��ͨ�û�":"����Ա"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return new SerchUserMenu();
	}

}
