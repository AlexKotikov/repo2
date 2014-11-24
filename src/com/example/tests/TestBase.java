package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTreeOperator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;
import com.example.fw.Folders;

public class TestBase {

	//protected  
	public  ApplicationManager app;

	
	
	@BeforeTest
	public void setUp() throws Exception {
		
		//String props = System.getProperty("config", "application.properties");		
		Properties prop = new Properties();
		//prop.load( new FileReader ( new File(props)));
		 //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		app = new ApplicationManager(prop);
	  } 

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

	
	protected static String GenNewString() {
		 String abc ="abcdefghijaeiouklmnopqrstuevwxoyaz"; 
		 StringBuilder str = new StringBuilder("");
		 String a ="";
		 int  rnd = 0;  
		 
		 for (int i=0; i < ( 5 +(int) (Math.random() * (11 -5))); i++ ) 
		 {  
			 rnd  = (  (int) (Math.random() * (abc.length()  )));
			 
			 
			 if (i == 0) {
			 a =  Character.toString(abc.charAt(rnd));
			 a = a.substring(0,1).toUpperCase();
			 str.append(a); }
			 else     
				   str.append(abc.charAt(rnd));		 
		 }
	return  str.toString(); }
	
	
	
	
	
}
