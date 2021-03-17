package model;

import structures.stack.*;

public class Client {

	private String name;
	private String id;
	private Stack<String> booksCodes;
	private String status;

	public Client(String name, String id) {
		this.name = name;
		this.id = id;
		setBooksCodes(new Stack<String>());
		setStatus("Incomplete");
	}
	
	public void addBookCode(String ISBN) {
		booksCodes.push(ISBN);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id; 
	}


	public Stack<String> getBooksCodes() {
		return booksCodes;
	}

	public void setBooksCodes(Stack<String> booksCodes) {
		this.booksCodes = booksCodes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
