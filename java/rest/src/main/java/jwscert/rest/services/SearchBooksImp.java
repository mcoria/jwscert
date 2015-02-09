package jwscert.rest.services;

import java.util.List;

import jwscert.rest.model.Book;
import jwscert.rest.model.BookStore;

public class SearchBooksImp implements SearchBooks {
	private BookStore bookStore = BookStore.getInstance();

	@Override
	public List<Book> searchByName(String name) {
		return bookStore.searchByName(name);
	}
	


}
