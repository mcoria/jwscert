package jwscert.rest.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookStore {
	
	private List<Book> books = new ArrayList<Book>();
	
	private BookStore() {}
	
	private static BookStore instance = new BookStore();
	public static synchronized  BookStore getInstance() {
		return instance;
	}
	
	public void reset(){
		books.clear();
		
		Book book1  = new Book();
		book1.setId(1);
		book1.setName("Name");
		
		Book book2  = new Book();
		book2.setId(2);
		book2.setName("Name2");
		
		books.addAll(Arrays.asList(book1, book2));		
	}

	public Book getById(int id){
		Book bookItem = null;
		for (Book book : books) {
			if(book.getId() == id){
				bookItem = book;
				break;
			}
		}
		return bookItem;
	}

	public List<Book> getAll() {
		return books;
	}

	public void create(Book book) {
		books.add(book);
	}

	public List<Book> searchByName(String name) {
		List<Book> booksResult = new ArrayList<Book>();
		for (Book book : books) {
			if(book.getName().contains(name)){
				booksResult.add(book);
			}
		}		
		return booksResult;
	}	
}
