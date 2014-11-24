package com.example.fw;

import java.util.ArrayList;
import java.util.List;

public class Folders {
   
	private List<String>  listoffolders;
	
	public Folders  (List<String> folders) {
	  	
		this.listoffolders = new ArrayList<String>(folders);
	} 
	
	
	
	public Folders  withAdded (String str) {		 	
		Folders sp = new Folders(listoffolders);
		sp.listoffolders.add(str);
		return sp ;	 
	}
	
	public int  size () {		 	
		Folders sp = new Folders(listoffolders);
		return sp.listoffolders.size();
		 
	}
	

	@Override
	public String toString() {
		return "Folders [listoffolders=" + listoffolders + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((listoffolders == null) ? 0 : listoffolders.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folders other = (Folders) obj;
		if (listoffolders == null) {
			if (other.listoffolders != null)
				return false;
		} else if (!listoffolders.equals(other.listoffolders))
			return false;
		return true;
	}



 

	
}
