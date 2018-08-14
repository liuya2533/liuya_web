package com.menu;

import com.adminmenuitem.AddUser;
import com.adminmenuitem.DeleteUser;
import com.adminmenuitem.ModifyUser;
import com.adminmenuitem.SerchUser;
import com.mainmenuitem.Exit;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.normalmenu.ModifySelfInfo;
import com.normalmenu.SerchSelfInfo;
import com.utils.ConsoleUtil;

public class AdminMenu implements Menu{

	public void showInfro() {
		// TODO Auto-generated method stub
		System.out.println("==============");
		System.out.println("欢迎登录主窗体！");
		System.out.println(Start.loginuser.getUsername()+" 您好！        "+"您的权限是：管理员");
		System.out.println("添加用户---------1");
		System.out.println("删除用户---------2");
		System.out.println("修改用户---------3");
		System.out.println("查询用户---------4");
		System.out.println("退出程序---------5");
		
	}

	public Item pickItem() {
		// TODO Auto-generated method stub
		Item item=null;
		int option=ConsoleUtil.getOption(1, 5);
		switch(option){
		case 1:
			item=new AddUser();
			break;
		case 2:
			item=new DeleteUser();
			break;
		case 3:
			item=new ModifyUser();
			break;
		case 4:
			item=new SerchUser();
			break;
		case 5:
			item=new Exit();
			break;
		}
		return item;
	}
}
