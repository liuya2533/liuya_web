package com.menu;

import com.mainmenuitem.Exit;
import com.mainmenuitem.LoginItem;
import com.mainmenuitem.RegItem;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.utils.ConsoleUtil;

public class MainMenu implements Menu{

	public void showInfro() {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用neusoft用户管理系统");
		System.out.println("===================");
		System.out.println("用户登录===========1");
		System.out.println("用户注册===========2");
		System.out.println("用户退出===========3");
		
	}

	public Item pickItem() {
		// TODO Auto-generated method stub
		Item item=null;
		//
		int option =ConsoleUtil.getOption(1, 3);
		switch(option){
		case 1:
			item=new LoginItem();
			break;
			
		case 2:
			item =new RegItem();
			break;
		case 3:
			item=new Exit();
		}
		return item;
	}

}
