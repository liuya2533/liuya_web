package com.menu;

import com.adminmenuitem.ReturnMenu;
import com.adminmenuitem.SerchUser;
import com.mainmenuitem.Exit;
import com.mainmenuitem.LoginItem;
import com.mainmenuitem.RegItem;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.serchuser_item.SerchAllUser;
import com.serchuser_item.SerchOneUser;
import com.utils.ConsoleUtil;

public class SerchUserMenu implements Menu{

	public void showInfro() {
		// TODO Auto-generated method stub
		System.out.println("============");
		System.out.println("查询所有用户--------1");
		System.out.println("查询单个用户--------2");
		System.out.println("返回--------------3");
	}

	public Item pickItem() {
		// TODO Auto-generated method stub
		Item item=null;
		//
		int option =ConsoleUtil.getOption(1, 3);
		switch(option){
		case 1:
			item=new SerchAllUser();
			break;
			
		case 2:
			item =new SerchOneUser();
			break;
		case 3:
			item=new ReturnMenu();
		}
		return item;
	}

}
