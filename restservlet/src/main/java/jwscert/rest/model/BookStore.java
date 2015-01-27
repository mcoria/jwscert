package jwscert.rest.model;

public class BookStore {
	private BookStore(){
	}
	
	private static BookStore instance = new BookStore();
	public static synchronized  BookStore getInstance() {
		return instance;
	}
}
