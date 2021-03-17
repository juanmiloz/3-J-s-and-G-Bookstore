package model;

import structures.hashTable.HashTable;

public class Bookshelve {

	private HashTable<String, Book> booksMap;
	private String name;
	
	public Bookshelve(int booksQuantity) {
		booksMap = new HashTable<String, Book>(booksQuantity);
	}
	
	public void addBook(String ISBN, Book book) {
		booksMap.put(ISBN, book);
	}

	public HashTable<String, Book> getBooksMap() {
		return booksMap;
	}

	public void setBooksMap(HashTable<String, Book> booksMap) {
		this.booksMap = booksMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
