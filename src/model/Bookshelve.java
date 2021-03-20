package model;

import structures.hashTable.HashTable;
import structures.hashTable.Node;

public class Bookshelve {

	private HashTable<String, Book> booksMap;
	private String name;
	/**
	 * Name: Bookshelve
	 * Constructor method of a bookshelve. <br>
	 * @param booksQuantity - quantity of books - quantity = int
	 */
	public Bookshelve(int booksQuantity) {
		booksMap = new HashTable<String, Book>(booksQuantity);
	}
	/**
	 * Name: addBook
	 * Method used to add a book to the hash table . <br>
	 * @param ISBN
	 * @param book
	 */
	public void addBook(String ISBN, Book book) {
		booksMap.put(ISBN, book);
	}
	/**
	 * Name: getBooksMap
	 * Method used to get the hash table of books. <br>
	 * @return A HashTable<String, Book> representing the hash table of books.
	*/
	public HashTable<String, Book> getBooksMap() {
		return booksMap;
	}
	/**
	 * Name: setBooksMap
	 * Method used to update the hash table of bookshelve  <br>
	 * @param HashTable<String, Book> booksMap - hash table bookshelve - booksMap = HashTable<String, Book> booksMap
	*/
	public void setBooksMap(HashTable<String, Book> booksMap) {
		this.booksMap = booksMap;
	}
	/**
	 * Name: getName
	 * Method used to get the name of the bookshelve. <br>
	 * @return A String representing the name of the bookshelve..
	*/
	public String getName() {
		return name;
	}
	/**
	 * Name: setName
	 * Method used to update the name of bookshelve.  <br>
	 * @param name - name of bookshelve - name = String, name != null, name != ""
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	public void getLastElement() {
		Book last = null;
		int pos = booksMap.getHashTable().length-1;
		while(last==null) {
			if(booksMap.getHashTable()[pos]!=null) {
				Node<String, Book> currentNode = booksMap.getHashTable()[pos]; 
				while(currentNode!=null) {
					if(currentNode.getNext()==null) {
						last = currentNode.getValue();
						currentNode = currentNode.getNext();
					}else {
						currentNode = currentNode.getNext();
					}
				}
			}else {
				pos --;
			}
		}
		
	}
}
