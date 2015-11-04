package business;

import java.time.LocalDate;
import java.util.List;

import ui.Overdue;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public interface ControllerInterface {
	public void addNewMember(String memberId, String firstName,
			String lastName, String telNumber, Address addr)
			throws LibrarySystemException;

	public LibraryMember search(String memberId);

	public void updateMemberInfo(String memberId, String firstName,
			String lastName, String telNumber, Address addr)
			throws LibrarySystemException;

	public void checkoutBook(String memberId, String isbn)
			throws LibrarySystemException;

	public boolean addBook(String isbn, String title, int maxCheckoutLength,
			List<Author> authors, int numCopies) throws LibrarySystemException;

	public boolean addBookCopy(String isbn) throws LibrarySystemException;

	public void printCheckoutRecord(String memberId)
			throws LibrarySystemException;

	//public CopyStatus computeStatus(BookCopy copy);

	public Book searchBook(String isbn);
	
	public boolean isMemberExist(String s);
	public boolean isBookExist(String s);
	public List<Overdue> getOverdue(String isbn);

}
