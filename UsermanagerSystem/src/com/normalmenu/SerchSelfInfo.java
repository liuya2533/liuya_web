package com.normalmenu;

import com.menu.NormalMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;

public class SerchSelfInfo implements Item{

	public Menu excute() {
		// TODO Auto-generated method stub
		System.out.println("================");
		System.out.println("您现在的信息是：");
		System.out.println(Start.loginuser.getId()+"  |  "+Start.loginuser.getUsername()+"  |  " +
				Start.loginuser.getPassword()+"  |  "+Start.loginuser.getEmail()+"  |  "+
				(Start.loginuser.getPower()==0?"普通用户":"管理员"));
		return new NormalMenu();
	}
}
