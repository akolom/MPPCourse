package ui;



import javafx.beans.property.SimpleStringProperty;

public class CheckoutTableModel {
	 
	private final SimpleStringProperty member = new SimpleStringProperty("");
	private final SimpleStringProperty isbn= new SimpleStringProperty("");
	private final SimpleStringProperty copy= new SimpleStringProperty("");
	private final SimpleStringProperty checkout= new SimpleStringProperty("");
	private final SimpleStringProperty due= new SimpleStringProperty("");
	
	public CheckoutTableModel(){
		this("","","","","");
	}
	
	public CheckoutTableModel(String member, String isbn, String copy, String checkout,
			String due) {
		
		setMember(member);
		setIsbn(isbn);
		setCopy(copy);
		setCheckout(checkout);
		setDue(due);
	}
		
	public String getMember() {
		return member.get();
	}
	public String getIsbn() {
		return isbn.get();
	}
	public String getCopy() {
		return copy.get();
	}
	public String getCheckout() {
		return checkout.get();
	}
	public String getDue() {
		return due.get();
	}
	
	public void setMember(String member){
		this.member.set(member);
	}
	
	public void setIsbn(String isbn){
		this.isbn.set(isbn);
	}
	public void setCopy(String copy){
		this.copy.set(copy);
	}
	public void setCheckout(String checkout){
		this.checkout.set(checkout);
	}
	public void setDue(String due){
		this.due.set(due);
	}
	
	

}
