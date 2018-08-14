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
		System.out.println("请输入要删除的用户的ID");
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
		Connection conn=Start.db.getConnect();
		while(true){
		try {
			PreparedStatement ps=conn.prepareStatement("select * from userinfo where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			//在删除之前先检查是否存在此id
			if(!rs.next()){
				System.out.println("用户名已被占用ID不存在！  请重新输入...");
				id=scan.nextInt();
				continue;
			}else{
				conn.setAutoCommit(false);
				ps=conn.prepareStatement("delete from userinfo where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				conn.commit();
				System.out.println("删除成功！");
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
