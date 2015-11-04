package business;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ui.Overdue;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;

	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if (!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if (!passwordFound.equals(password)) {
			throw new LoginException(
					"Passord does not match password on record");
		}
		currentAuth = map.get(id).getAuthorization();

	}

	/**
	 * This method checks if memberId already exists -- if so, it cannot be
	 * added as a new member, and an exception is thrown. If new, creates a new
	 * LibraryMember based on input data and uses DataAccess to store it.
	 * 
	 */
	public void addNewMember(String memberId, String firstName,
			String lastName, String telNumber, Address addr)
			throws LibrarySystemException {
		LibraryMember member = new LibraryMember(firstName, lastName,
				telNumber, addr, memberId);
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(member);

	}
	
	
	
	/**
	 * Reads data store for a library member with specified id. Ids begin at
	 * 1001... Returns a LibraryMember if found, null otherwise
	 * 
	 */
	public LibraryMember search(String memberId) {
		DataAccess da = new DataAccessFacade();
		return da.searchMember(memberId);
	}

	/**
	 * Same as creating a new member (because of how data is stored)
	 */
	public void updateMemberInfo(String memberId, String firstName,
			String lastName, String telNumber, Address addr) {
		LibraryMember member = new LibraryMember(firstName, lastName,
				telNumber, addr, memberId);
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(member);

	}
	
	
	public boolean isMemberExist(String s){
		DataAccess da = new DataAccessFacade();
		return da.memeberIDStartWith(s);
	}

	
	public boolean isBookExist(String s){
		DataAccess da = new DataAccessFacade();
		return da.isbnStartWith(s);
	}
	
	/**
	 * Looks up Book by isbn from data store. If not found, an exception is
	 * thrown. If no copies are available for checkout, an exception is thrown.
	 * If found and a copy is available, member's checkout record is updated and
	 * copy of this publication is set to "not available"
	 */
	@Override
	public void checkoutBook(String memberId, String isbn)
			throws LibrarySystemException {
		DataAccess da = new DataAccessFacade();
		Book book = searchBook(isbn);
		if(book==null) throw new LibrarySystemException();
		else if(!book.isAvailable()) throw new LibrarySystemException();
		else{
			LibraryMember member = search(memberId);
			BookCopy copy = book.getNextAvailableCopy();
		    CheckoutRecordEntry entry = new CheckoutRecordEntry(LocalDate.now(), LocalDate.now().plusDays(book.getMaxCheckoutLength()), book.getIsbn(), copy);
			member.getRecord().addEntry(entry);
			copy.changeAvailability();
			book.updateCopies(copy);
			da.updateMember(member);
			da.updateBook(book);
			
		}

	}

	@Override
	public Book searchBook(String isbn) {
		DataAccess da = new DataAccessFacade();
		return da.searchBook(isbn);
	}

	/**
	 * Looks up book by isbn to see if it exists, throw exceptioni. Else add the
	 * book to storage
	 */
	public boolean addBook(String isbn, String title, int maxCheckoutLength,
			List<Author> authors, int numCopies) throws LibrarySystemException {
		Book book = new Book(isbn, title, maxCheckoutLength, authors);
		for(int i=1; i<numCopies; i++){
			book.addCopy();
		}
		DataAccess da = new DataAccessFacade();
		da.saveNewBook(book);
		return true;

	}

	public boolean addBookCopy(String isbn) throws LibrarySystemException {
		Book book = searchBook(isbn);
		if (book == null)
			throw new LibrarySystemException("No book with isbn " + isbn
					+ " is in the library collection!");
		book.addCopy();
		DataAccess da = new DataAccessFacade();
		da.updateBook(book);
		return true;
	}

	public void printCheckoutRecord(String memberId)
			throws LibrarySystemException {
		LibraryMember member = search(memberId);
		System.out.print("Check out Record for ");
		System.out.println(member.getFirstName()+", "+member.getLastName());
		System.out.println("Checkout Date \t\t Due Date \t\t\t\t Book \t\t Copy Number \t\t isAvailable");
		for(CheckoutRecordEntry entry: member.getRecord().getCheckoutRecordEntries()){
		System.out.println(entry);
		}

	}

	public List<Overdue> getOverdue(String isbn){
		DataAccess da = new DataAccessFacade();
		List<Overdue> list = new ArrayList<>();
		Book book = da.searchBook(isbn);
		HashMap<String, LibraryMember> map = da.allMember();
		for(Map.Entry<String, LibraryMember> entry: map.entrySet()){
			CheckoutRecord record = entry.getValue().getRecord();
			String member = entry.getValue().getMemberID();
			for(CheckoutRecordEntry e: record.getCheckoutRecordEntries()){
				if(!e.equals(null) && e.getBook().equals(isbn)){
					Overdue overdue = new Overdue(isbn, book.getTitle(), member, Integer.valueOf(e.getCopy().getCopyNum()).toString(), e.getDueDate().toString());
					list.add(overdue);
				}
			}
		}
		return list;
		
	}
}
