package com.menu;

import com.mainmenuitem.Exit;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;
import com.nensoft.start.Start;
import com.normalmenu.ModifySelfInfo;
import com.normalmenu.SerchSelfInfo;
import com.utils.ConsoleUtil;

public class NormalMenu implements Menu{

	public void showInfro() {
		// TODO Auto-generated method stub
		System.out.println("==============");
		System.out.println("��ӭ��¼�����壡");
		System.out.println(Start.loginuser.getUsername()+" ���ã�        "+"����Ȩ���ǣ���ͨ�û�");
		System.out.println("�޸��Լ�����Ϣ---------1");
		System.out.println("��ѯ�Լ�����Ϣ---------2");
		System.out.println("�˳�����--------------3");
	}

	public Item pickItem() {
		// TODO Auto-generated method stub
		Item item=null;
		int option=ConsoleUtil.getOption(1, 3);
		switch(option){
		case 1:
			item=new ModifySelfInfo();
			break;
		case 2:
			item=new SerchSelfInfo();
			break;
		case 3:
			item=new Exit();
		}
		return item;
	}

}
