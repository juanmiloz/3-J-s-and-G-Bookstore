package model;

public class Book {
	
	private String title;
	private double price;
	private String author;
	private int year;
	private String sumary;
	
	public Book(String title, double price, String author, int year, String sumary) {
		this.setTitle(title);
		this.setPrice(price);
		this.setAuthor(author);
		this.setYear(year);
		this.setSumary(sumary);
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSumary() {
		return sumary;
	}

	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	
}
