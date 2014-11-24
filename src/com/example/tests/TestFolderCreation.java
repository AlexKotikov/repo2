package com.example.tests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.netbeans.jemmy.ClassReference;
import org.testng.annotations.Test;

import com.example.fw.Folders;
 
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.*;
import static com.example.tests.TestBase.GenNewString;

public class TestFolderCreation extends TestBase {

	
  
	
	// @Test   //Проверить что папка со случайным валидным именем создается
	public void testFolderCreation() {		
		
		String folder = GenNewString();		
		Folders  oldlist = app.getFoldersHelper().getFolders();			 
		app.getFoldersHelper().addNewFolder(folder);     		
		Folders  newlist = app.getFoldersHelper().getFolders();
		assertThat(newlist, equalTo(oldlist.withAdded(folder)));
			 
	}
	
	//@Test   //Проверить что вторая папка с существущим именем не создается.
			//Проверить что выводится варнинг
	public void testFolderCreation2() {		
		String folder = GenNewString();		
		Folders  oldlist = app.getFoldersHelper().getFolders();		
		assertThat(app.getFoldersHelper().addNewFolder(folder),is("")); //Первая должна создаваться без проблем	
		assertThat(app.getFoldersHelper().addNewFolder(folder),containsString("Duplicated"));	 
		Folders  newlist = app.getFoldersHelper().getFolders();	
		assertThat(newlist, equalTo(oldlist.withAdded(folder))); //список должен быть таким же как до добавления папки
	}
	
	@Test   //Проверить что папка удаляется
		    //Проверить что выводится варнинг Confirm
		public void testFolderDelete()
		{			  
			Folders  oldlist = app.getFoldersHelper().getFolders();
			// get folder to delete it
			 app.getFoldersHelper().selectFolderByRandomIndex(oldlist);		
			// click Cross Btn
			//assertThat(app.getFoldersHelper().withDeletedFolder(folder),containsString("Confirm"));  
			//Folders  newlist = app.getFoldersHelper().getFolders();	
			//assertThat(newlist, equalTo(oldlist.withDeletedFolder(folder))); 
		
		}

		

		
	
	
}
