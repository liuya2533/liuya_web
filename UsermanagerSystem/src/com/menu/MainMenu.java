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
		System.out.println("��ӭʹ��neusoft�û�����ϵͳ");
		System.out.println("===================");
		System.out.println("�û���¼===========1");
		System.out.println("�û�ע��===========2");
		System.out.println("�û��˳�===========3");
		
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
