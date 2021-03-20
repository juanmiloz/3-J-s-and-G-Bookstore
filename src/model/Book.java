package model;

public class Book implements Comparable<Book> {
	
	private String title;
	private double price;
	private String author;
	private int quantity;
	private String ISBN;
	private int shelve;
	private int posInShelve;
	private int bookCount;
	
	/**
	 * Name: book
	 * Constructor method of a book. <br>
	 * @param title - title of the book  - title = String, title != null, title != ""
	 * @param price - price of the book - price = double
	 * @param author - author of the book - author = String, title != null, title != ""
	 * @param sumary - sumary of the book - sumary = String, title != null, title != ""
	 * @param quantity - quantity of books - quantity = int
	 * @param ISBN - ISBN of the book - ISBN = String, title != null, title != ""
	 * @param shelve - shelve of the book - shelve = int, shelve!=null
	 * @param posInShelve - shelve the book is in - posInShelve = int, posInShelve!=null
	 */
	
	public Book(String title, double price, String author, int quantity, String ISBN, int shelve, int posInShelve,
			int bookCount) {
	
		this.title = title;
		this.price = price;
		this.author = author;
		this.quantity = quantity;
		this.ISBN = ISBN;
		this.shelve = shelve;
		this.posInShelve = posInShelve;
		this.bookCount=bookCount;
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


	public int getPosInShelve() {
		return posInShelve;
	}


	public void setPosInShelve(int posInShelve) {
		this.posInShelve = posInShelve;
	}


	public int getShelve() {
		return shelve;
	}


	public void setShelve(int shelve) {
		this.shelve = shelve;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	@Override
	public int compareTo(Book o) {
		if(getBookCount() > o.getBookCount()) {
			return 1;
		} else if(getBookCount() < o.getBookCount()) {
			return -1;
		}
		return 0;
	}
	
}
