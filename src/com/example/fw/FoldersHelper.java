package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTree;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;
import org.netbeans.jemmy.operators.JTextAreaOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import  com.example.tests.TestBase ;

public class FoldersHelper extends HelperBase {
	
	
	
	/* такой конструктор нужен для того что бы хелпер знал 
	какой конкретно класс проинициализоровался до него чтобы он 
	мог начать свою работу после того как приложение готово, а не лезть вперед.
	Есть ссылка на объект выше, она позволяет обращаться к методам этого объекта
	если потребуется что-то более глобальное (запустить приложение\перейти куда либо)
	 
	Эта ссыкла дает гарантию что объект который "до" готов и отработал свою часть.
	*/
	
	FoldersHelper (ApplicationManager man) {
		super(man);
	
	}
	
	
	// должен возвращать список фолдеров из приложения
	public Folders getFolders() {
		List<String>  list = new ArrayList<String>();
		JFrameOperator aa = mainframe; // пример такого обращения по ссылке  
	    JTreeOperator tree = new JTreeOperator(aa);
		Object[] children = tree.getChildren(tree.getRoot());		
		for (Object a : children) {		
			list.add(a+ "");
		}
		
	/*	System.out.println("---s ---");
		for (Object a : children) {		
			System.out.println(a.toString());
		}
		System.out.println("---e  ---");
	*/
		return new Folders(list);
	}

	public String addNewFolder(String folder) {	
		manager.getMenuHelper().pushNewFolder(folder);
		JDialogOperator dia = new JDialogOperator(mainframe);
		new JTextFieldOperator(dia).setText(folder);
		new JButtonOperator(dia,"OK").push();
		 
 	 return checkWarning("Warning",3000);
	}

	public void selectFolderByRandomIndex(Folders oldlist) {
 
			int  count = oldlist.size();	 	
			int  i = (int)  (1+ Math.random() *  (count -1) );
			
			JFrameOperator aa = mainframe;  
		    JTreeOperator tree = new JTreeOperator(aa);
			//Object[] children = tree.getChildren(tree.getRoot());	
		 
			
	}
	

}
