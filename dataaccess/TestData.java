package dataaccess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.*;

public class TestData {
	//List<LibraryMember> members = new ArrayList<LibraryMember>();
	@SuppressWarnings("serial")
	
	
	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("18 bannker way", "Sanfrancisco", "CA", "52556"));
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
			add(new Address("42 Haight Dr.", "Sanfrancisco", "CA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "u"));
		}
	};
	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("Aki", "Gebre", "641-445-2123", addresses.get(0), "A happy man is he."));
			add(new Author("Sandra", "Thomas", "641-445-2123", addresses.get(0), "A happy wife is she."));
			add(new Author("Anderias", "Pugh", "415-410-9351", addresses.get(1), "Thinker of thoughts."));
			add(new Author("Andrew", "Cleveland", "976-445-2232", addresses.get(2), "Author of childrens' books."));
			add(new Author("Sarah", "Connor", "123-422-2663", addresses.get(3), "Known for her clever style."));
		}
	};
	
	@SuppressWarnings("serial")
	public List<LibraryMember> allMembers = new ArrayList<LibraryMember>() {
		{
			add(new LibraryMember("Joe", "Thomas", "641-445-2123", addresses.get(4), "108971"));
			add(new LibraryMember("Sandra", "Thomas", "641-445-2123", addresses.get(5), "872224"));
			add(new LibraryMember("Nirmal", "Pugh", "641-919-3223", addresses.get(6), "672821"));
			
		}
	};
	
	//Book(int id, String isbn, String title, int maxCheckoutLength, List<Author> authors)
	@SuppressWarnings("serial")
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("23-11451", "The Big Fish", 21, Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
			add(new Book("28-12331", "Antartica", 7, Arrays.asList(allAuthors.get(2))));
			add(new Book("99-22223", "Thinking Java", 21, Arrays.asList(allAuthors.get(3))));
			add(new Book("48-56882", "Jimmy's First Day of School", 7, Arrays.asList(allAuthors.get(4))));
			
		}
	};
	
	
	List<CheckoutRecord> allRecords = new ArrayList<CheckoutRecord>() {
	{		add(new CheckoutRecord());
			add(new CheckoutRecord());
		add(new CheckoutRecord());
		add(new CheckoutRecord());
		add(new CheckoutRecord());
		add(new CheckoutRecord());
			add(new CheckoutRecord());
		}
	};
	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("111", "aki", Auth.LIBRARIAN));
			add(new User("112", "massawa", Auth.ADMIN));
			add(new User("113", "111", Auth.BOTH));
		}
	};
	
	public static void main(String[] args) {
		TestData td = new TestData();
		td.bookData();
	td.libraryMemberData();
		td.userData();
		DataAccess da = new DataAccessFacade();
		System.out.println(da.readBooksMap());
	System.out.println(da.readUserMap());
	System.out.println(da.readMemberMap());
	}
	///create books
	public void bookData() {
		allBooks.get(0).addCopy();
		allBooks.get(0).addCopy();
		allBooks.get(1).addCopy();
		allBooks.get(3).addCopy();
		allBooks.get(2).addCopy();
		allBooks.get(2).addCopy();
		DataAccessFacade.loadBookMap(allBooks);
	}
	
	public void userData() {
		DataAccessFacade.loadUserMap(allUsers);
	}
	
	/*
	public void checkoutRecordData() {
		allRecords.get(0).addEntry(allEntries.get(0));
		allRecords.get(0).addEntry(allEntries.get(4));
		allRecords.get(1).addEntry(allEntries.get(1));
		allRecords.get(1).addEntry(allEntries.get(5));
		allRecords.get(2).addEntry(allEntries.get(2));
		allRecords.get(2).addEntry(allEntries.get(6));
		allRecords.get(3).addEntry(allEntries.get(3));
		allRecords.get(3).addEntry(allEntries.get(7));
	}*/
	
	public void libraryMemberData() {
		DataAccessFacade.loadMemberMap(allMembers);
		
	}
		
	
}
