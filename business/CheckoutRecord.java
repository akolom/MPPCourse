package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6210690276685962829L;
	
	private List<CheckoutRecordEntry> checkoutRecordEntries=new ArrayList<>();;
	
	
	public void addEntry(CheckoutRecordEntry entry){
		checkoutRecordEntries.add(entry);
	}

	public List<CheckoutRecordEntry> getCheckoutRecordEntries() {
		return checkoutRecordEntries;
	}
	
	public String toString(){
		return checkoutRecordEntries.toString();
	}

}
