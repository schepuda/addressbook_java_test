package com.example.framework;

import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper {
	
	private final ApplicationManager manager;
	
	public MenuHelper(ApplicationManager applicationManager) {
		this.manager = applicationManager;
	}

	public void pushCreateFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(manager.getApplication());
		menu.pushMenuNoBlock("File|New folder...");
	}


}
