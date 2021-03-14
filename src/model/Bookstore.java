package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bookstore {
	
	private int numberOfCashiers;
	private Bookshelve[] bookshelves;
	private List<HashMap<String, Book>> stands;
	
	public Bookstore() {
		
	}
	
	public boolean addBook() {
		//Book bookToAdd = new Book();
		return false;
	}
	
	public void initializeStore(int cashiers, int shelves) {
		numberOfCashiers=cashiers;
		bookshelves= new Bookshelve[shelves];
		setStands(new ArrayList<HashMap<String, Book>>());
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


	public List<HashMap<String, Book>> getStands() {
		return stands;
	}


	public void setStands(ArrayList<HashMap<String, Book>> arrayList) {
		this.stands = arrayList;
	}
}
