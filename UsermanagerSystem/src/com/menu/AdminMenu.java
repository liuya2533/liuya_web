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
		System.out.println("��ӭ��¼�����壡");
		System.out.println(Start.loginuser.getUsername()+" ���ã�        "+"����Ȩ���ǣ�����Ա");
		System.out.println("����û�---------1");
		System.out.println("ɾ���û�---------2");
		System.out.println("�޸��û�---------3");
		System.out.println("��ѯ�û�---------4");
		System.out.println("�˳�����---------5");
		
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
