package com.adminmenuitem;

import com.menu.AdminMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;

public class ReturnMenu implements Item {

	public Menu excute() {
		// TODO Auto-generated method stub
		return new AdminMenu();
	}

}
