package ui;



import javafx.beans.property.SimpleStringProperty;

public class Overdue {
	 
	private final SimpleStringProperty isbnProperty = new SimpleStringProperty("");
	private final SimpleStringProperty titleProperty= new SimpleStringProperty("");
	private final SimpleStringProperty memberProperty= new SimpleStringProperty("");
	private final SimpleStringProperty copyNumProperty= new SimpleStringProperty("");
	private final SimpleStringProperty dueDateProperty= new SimpleStringProperty("");
	
	public Overdue(){
		this("","","","","");
	}
	
	public Overdue(String isbn, String title, String member, String copyNum,
			String dueDate) {
		
		setIsbnProperty(isbn);
		setTitleProperty(title);
		setMemberProperty(member);
		setCopyNumProperty(copyNum);
		setDueDateProperty(dueDate);
	}
		
	public String getIsbnProperty() {
		return isbnProperty.get();
	}
	public String getTitleProperty() {
		return titleProperty.get();
	}
	public String getMemberProperty() {
		return memberProperty.get();
	}
	public String getCopyNumProperty() {
		return copyNumProperty.get();
	}
	public String getDueDateProperty() {
		return dueDateProperty.get();
	}
	
	public void setIsbnProperty(String isbn){
		this.isbnProperty.set(isbn);
	}
	
	public void setTitleProperty(String title){
		this.titleProperty.set(title);
	}
	public void setMemberProperty(String member){
		this.memberProperty.set(member);
	}
	public void setCopyNumProperty(String copyNum){
		this.copyNumProperty.set(copyNum);
	}
	public void setDueDateProperty(String due){
		this.dueDateProperty.set(due);
	}
	
	public String toString(){
		return "("+isbnProperty+", "+titleProperty+",  "+memberProperty+", "+copyNumProperty+", "+dueDateProperty+")";
	}
	

}
