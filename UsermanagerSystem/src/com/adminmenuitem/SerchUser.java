package com.adminmenuitem;

import com.menu.SerchUserMenu;
import com.nensoft.bean.Item;
import com.nensoft.bean.Menu;

public class SerchUser implements Item{

	public Menu excute() {
		// TODO Auto-generated method stub
		return new SerchUserMenu();
	}

}
