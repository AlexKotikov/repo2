package com.example.fw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;


public class ApplicationManager {

	 
	public  String baseUrl;
	public FoldersHelper foldersHelper;
	private JFrameOperator frame;
	public MenuHelper menuHelper;
	
 
	
	protected String returnBaseURL(){
	   return this.baseUrl;
	}
	
	public ApplicationManager(Properties prop) throws FileNotFoundException, IOException {	 
		//baseUrl = prop.getProperty("baseurl");
	}
	
	public void stop() {
		// посылаем приложению сингал о корректном завершении
		// чтобы оно сохранило свои данные.
		 GetApplication().requestClose();
	}

	public FoldersHelper getFoldersHelper() {
		 if (foldersHelper == null) {
			 foldersHelper = new FoldersHelper(this);
		} 
		return foldersHelper;
	}
	
	public MenuHelper getMenuHelper() {
		 if (menuHelper == null) {
			 menuHelper = new MenuHelper(this);
		} 
		return menuHelper;
	}
	

	public JFrameOperator GetApplication() {
	
		if (frame == null) { 
		
		try {
			new ClassReference("addressbook.AddressBookFrame").startApplication();
		    
			frame = new JFrameOperator("jAddressBook"); 
				
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		}
		return frame;		
	}


	
}
