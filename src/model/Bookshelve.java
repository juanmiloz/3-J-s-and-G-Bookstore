package model;

import java.util.HashMap;

public class Bookshelve {

	public HashMap<String, Book> booksMap;
	
	public Bookshelve() {
		booksMap = new HashMap<String, Book>();
	}
	
	public void addBook(String ISBN, Book book) {
		booksMap.put(ISBN, book);
	}

	public HashMap<String, Book> getBooksMap() {
		return booksMap;
	}

	public void setBooksMap(HashMap<String, Book> booksMap) {
		this.booksMap = booksMap;
	}
	
}
