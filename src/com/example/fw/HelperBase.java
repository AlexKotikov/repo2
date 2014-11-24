package com.example.fw;

import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

public class HelperBase {

	protected final ApplicationManager manager;
	protected JFrameOperator mainframe ;
	
	
	public HelperBase(ApplicationManager applicationManager) {
		this.manager = applicationManager;
		this.mainframe = manager.GetApplication();
		
	}
	
	
	
	
	protected String checkWarning(String title, int timeout) {
		 long start= System.currentTimeMillis(); // начальное  время в милисеках
		 long curr =  start;
		 String message ="";
		
		 while  (curr < start + timeout ) {
		
			 // проверяем что такой диалог нам был показан
			 JDialog findJDialog = JDialogOperator.findJDialog(mainframe.getOwner(),title,false,false);
			 
			 //Если мы его нашли то содаем из него объект и проверяем, что у этого объекта такой заголовок
			 //как нам нужно иначе продолжаем его ждать.
			 //когда нашли обращемся к его лэбл чтобы взять текст.
			if (findJDialog !=null) {			
				JDialogOperator  okosho = new JDialogOperator(findJDialog);
				message = new JLabelOperator(okosho).getText();// закроем это окно
				okosho.requestClose();
				return message;
					
			}
			 try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	 
		 curr = System.currentTimeMillis();
		 
		 }
		 
		return message;
	}
	
}
