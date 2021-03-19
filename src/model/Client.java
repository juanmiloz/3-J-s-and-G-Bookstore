package model;

import structures.stack.*;

public class Client {

	private String name;
	private String id;
	private Stack<String> booksCodes;
	private String status;
	/**
	 * Name: client
	 * Method constructor of client <br>
	 * @param name - client name - name = String, name != null, name != ""
	 * @param id - client id - id = String, id != null, id != ""
	 */
	public Client(String name, String id) {
		this.name = name;
		this.id = id;
		setBooksCodes(new Stack<String>());
		setStatus("Catalog");
	}
	/**
	 * Name: addBookCode
	 * Method to add a new book code <br>
	 * @param ISBN - book ISBN - ISBN = String, ISBN != null, ISBN != ""
	 */
	public void addBookCode(String ISBN) {
		booksCodes.push(ISBN);
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
	 * Name: getBooksCodes
	 * Method used to get the title of the book. <br>
	 * @return A Stack<String> representing stack whit books codes.
	*/
	public Stack<String> getBooksCodes() {
		return booksCodes;
	}
	/**
	 * Name: setBooksCodes
	 * Method used to update the stack of books code.  <br>
	 * @param booksCodes - books codes - booksCodes = Stack<String>
	*/
	public void setBooksCodes(Stack<String> booksCodes) {
		this.booksCodes = booksCodes;
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


}
