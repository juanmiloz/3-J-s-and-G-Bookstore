package model;

import java.util.ArrayList;

import structures.stack.*;

public class Client {

	private String name;
	private String id;
	private ArrayList<Book> booksCodes;
	private Stack<String> sortedBookBasket;
	private int time;
	private String status;
	/**
	 * Name: client
	 * Method constructor of client <br>
	 * @param name - client name - name = String, name != null, name != ""
	 * @param id - client id - id = String, id != null, id != ""
	 * @param time - client time - time = int
	 */
	public Client(String name, String id, int time) {
		this.name = name;
		this.id = id;
		this.time= time;
		booksCodes= new ArrayList<>();
		setSortedBookBasket(new Stack<String>());
		setStatus("Catalog");
	}
	/**
	 * Name: addBook
	 * Method to add a new book  <br>
	 * @param b -Book  , b != null
	 */
	public void addBook(Book b) {
		booksCodes.add(b);
	}
	/**
	 * Name: getName
	 * Method used to get client name <br>
	 * @return A String representing name of client.
	*/
	public String getName() {
		return name;
	}
	/**
	 * Name: setName
	 * Method used to update client name.  <br>
	 * @param name - client name - name = String, name != null, name != ""
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Name: getId
	 * Method used to get client id. <br>
	 * @return A String representing client id.
	*/
	public String getId() {
		return id;
	}
	/**
	 * Name: setId
	 * Method used to update client id  <br>
	 * @param id - client id - id = String, id != null, id != ""
	*/
	public void setId(String id) {
		this.id = id; 
	}

	/**
	 * Name: sortedBookBasket
	 * Method used to get the title of the book. <br>
	 * @return A Stack<String> representing stack whit sorted books.
	*/
	public Stack<String> getSortedBookBaskets() {
		return sortedBookBasket;
	}
	/**
	 * Name: sortedBookBasket
	 * Method used to update the stack of sorted books.  <br>
	 * @param SortedBookBasket - SortedBookBasket - SortedBookBasket = Stack<String>
	*/
	public void setSortedBookBasket(Stack<String> sortedBookBasket) {
		this.sortedBookBasket = sortedBookBasket;
	}
	
	
	
	public ArrayList<Book> getBooksCodes() {
		return booksCodes;
	}
	public void setBooksCodes(ArrayList<Book> books) {
		this.booksCodes = books;
	}
	/**
	 * Name: getStatus
	 * Method used to get client status. <br>
	 * @return A String representing client status.
	*/
	public String getStatus() {
		return status;
	}
	/**
	 * Name: setStatus
	 * Method used to update client status.  <br>
	 * @param status - client status - status = String, status != null, status != ""
	*/
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	


}
