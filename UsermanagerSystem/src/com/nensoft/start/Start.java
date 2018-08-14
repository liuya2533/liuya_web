package com.nensoft.start;

import com.menu.MainMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.bean.Userinfo;
import com.utils.DBUtil2;

public class Start {

	public static Userinfo loginuser=new Userinfo();
	public static DBUtil2 db=DBUtil2.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Menu menu=new MainMenu();
		while(menu != null){
			//显示内容
			menu.showInfro();
			Item item=menu.pickItem();
			menu=item.excute();
		}
		System.out.println("谢谢使用，再见，拜拜！");
	}
}
