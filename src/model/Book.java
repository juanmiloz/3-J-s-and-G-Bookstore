package model;

public class Book {
	
	private String title;
	private double price;
	private String author;
	private String sumary;
	private int quantity;
	private String ISBN;
	
	/**
	 * Name: book
	 * Constructor method of a book. <br>
	 * @param title - title of the book  - title = String, title != null, title != ""
	 * @param price - price of the book - price = double
	 * @param author - author of the book - author = String, title != null, title != ""
	 * @param sumary - sumary of the book - sumary = String, title != null, title != ""
	 * @param quantity - quantity of books - quantity = int
	 * @param ISBN - ISBN of the book - ISBN = String, title != null, title != ""
	 */
	public Book(String title, double price, String author, String sumary, int quantity, String ISBN) {
		this.setTitle(title);
		this.setPrice(price);
		this.setAuthor(author);
		this.setSumary(sumary);
		this.setQuantity(quantity);
		this.setISBN(ISBN);
	}
	/**
	 * Name: getTitle
	 * Method used to get the title of the book. <br>
	 * @return A String representing the title of the book.
	*/
	public String getTitle() {
		return title;
	}
	/**
	 * Name: setTitle
	 * Method used to update the title of the book.  <br>
	 * @param title - title of the book - title = String, title != null, title != ""
	*/
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Name: getPrice
	 * Method used to get the price of the book. <br>
	 * @return A double representing the price of the book.
	*/
	public double getPrice() {
		return price;
	}
	/**
	 * Name: setPrice
	 * Method used to update thePrice of the book.  <br>
	 * @param price - price of the book - price = double
	*/
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Name: getAuthor
	 * Method used to get the author of the book. <br>
	 * @return A String representing the author of the book.
	*/
	public String getAuthor() {
		return author;
	}
	/**
	 * Name: setAuthor
	 * Method used to update the author of the book.  <br>
	 * @param author - author of the book - author = String, author != null, author != ""
	*/
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * Name: getSumary
	 * Method used to get the sumary of the book <br>
	 * @return A String representing the sumary of the book.
	*/
	public String getSumary() {
		return sumary;
	}
	/**
	 * Name: setSumary
	 * Method used to update the sumary of the book.  <br>
	 * @param sumary - sumary of the book - sumary = String, sumary != null, sumary != ""
	*/
	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	/**
	 * Name: getQuantity
	 * Method used to get the quantity of books. <br>
	 * @return A int representing the quantity of books .
	*/
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Name: setQuantity
	 * Method used to update the quantity of books.  <br>
	 * @param quantity -  the quantity of books - quantity = int 
	*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * Name: getISBN
	 * Method used to get the ISBN of the book. <br>
	 * @return A String representing the ISBN of the book.
	*/
	public String getISBN() {
		return ISBN;
	}
	/**
	 * Name: setISBN
	 * Method used to update theISBN of the book.  <br>
	 * @param iSBN - ISBN of the book - iSBN = String, iSBN != null, iSBN != ""
	*/
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	/**
	 * Name: decreaseQuantity
	 * Method used to update the quantity of books.  <br>
	*/
	public void decreaseQuantity() {
		setQuantity(getQuantity() - 1);
	}
	
}
