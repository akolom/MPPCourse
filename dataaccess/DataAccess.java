package dataaccess;

import java.util.HashMap;

import business.Book;
import business.LibraryMember;





public interface DataAccess {
	public LibraryMember searchMember(String memberId);
	public Book searchBook(String isbn);
	public HashMap<String, LibraryMember> allMember();
	
	public boolean memeberIDStartWith(String s);
	public boolean isbnStartWith(String s);
	
	///////save methods
	public void saveNewMember(LibraryMember member);
	public void updateMember(LibraryMember member);
	
	//save new book
	public void saveNewBook(Book book);
	public void updateBook(Book book);
	
	//////read methods 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
}
