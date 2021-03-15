package model;

public class Bookstore {
	
	private int numberOfCashiers;
	private Bookshelve[] bookshelves;
	
	public Bookstore() {
		
	}
	
	public boolean addBook(String ISBN, Book book, int posShelve) {
		boolean canAdded = true;
		for(int c = 0; c < bookshelves.length; c++) {
			if(bookshelves[c].getBooksMap().containsKey(ISBN) == true) {
				canAdded = false;
			};
		}
		if(canAdded) {
			bookshelves[posShelve].addBook(ISBN, book);
		}
		return canAdded;
	}
	
	public void initializeStore(int cashiers, int shelves) {
		numberOfCashiers=cashiers;
		bookshelves = new Bookshelve[shelves];
		for(int c = 0; c < bookshelves.length; c++) {
			bookshelves[c] = new Bookshelve();
		}
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
