package model;

public class Bookstore {
	
	private int numberOfCashiers;
	private Bookshelve[] bookshelves;

	public Bookstore() {
		
	}
	
	
	public void initializeStore(int cashiers, int shelves) {
		numberOfCashiers=cashiers;
		bookshelves= new Bookshelve[shelves];
	}


	public int getNumberOfCashiers() {
		return numberOfCashiers;
	}


	public void setNumberOfCashiers(int numberOfCashiers) {
		this.numberOfCashiers = numberOfCashiers;
	}


	public Bookshelve[] getBookshelves() {
		return bookshelves;
	}


	public void setBookshelves(Bookshelve[] bookshelves) {
		this.bookshelves = bookshelves;
	}
	
	
	

}
