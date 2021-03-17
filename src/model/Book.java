package model;

public class Book {
	
	private String title;
	private double price;
	private String author;
	private String sumary;
	private int quantity;
	private String ISBN;
	
	public Book(String title, double price, String author, String sumary, int quantity, String ISBN) {
		this.setTitle(title);
		this.setPrice(price);
		this.setAuthor(author);
		this.setSumary(sumary);
		this.setQuantity(quantity);
		this.setISBN(ISBN);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSumary() {
		return sumary;
	}

	public void setSumary(String sumary) {
		this.sumary = sumary;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void decreaseQuantity() {
		setQuantity(getQuantity() - 1);
	}
	
}
