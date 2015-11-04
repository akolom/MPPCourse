package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntry implements Serializable{

	
	private static final long serialVersionUID = -6067205610381930196L;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private String book;
	private BookCopy copy;
	
	public CheckoutRecordEntry(LocalDate checkoutDate, LocalDate dueDate, String book, BookCopy copy){
		this.checkoutDate=checkoutDate;
		this.dueDate=dueDate;
		this.book=book;
		this.copy=copy;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public BookCopy getCopy() {
		return copy;
	}
	public String getBook() {
		return book;
	}
	
	public String toString(){
		return checkoutDate+"\t\t"+dueDate+"\t\t"+"\t\t"+book+"\t\t"+copy.getCopyNum()+"\t\t"+copy.isAvailable();
	}

	

}
