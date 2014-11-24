package com.example.fw;

import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper  extends HelperBase {
	
	
	public MenuHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}


	public void pushNewFolder(String folder) {
		
		JMenuBarOperator menu = new JMenuBarOperator(mainframe);
		menu.pushMenuNoBlock("File|New Folder..");
	}
 
	
 
	
}
