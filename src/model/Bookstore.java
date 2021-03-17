package model;

import java.util.ArrayList;

import structures.hashTable.Node;

public class Bookstore {
	
	private int numberOfCashiers;
	private Bookshelve[] bookshelves;
	private ArrayList<Client> clients;
	
	public Bookstore() {
		clients = new ArrayList<>();
	}
	
	public void initializateBookshelves(int position, int booksQuantity, String name) {
		bookshelves[position] = new Bookshelve(booksQuantity);
		bookshelves[position].setName(name);
	}
	
	public boolean addBook(String ISBN, Book book, int posShelve) {
		boolean canAdded = true;
		for(int c = 0; c < bookshelves.length; c++) {
			if(bookshelves[c] != null) {
				if(bookshelves[c].getBooksMap().existKey(ISBN) == true) {
					canAdded = false;
				};
			}
		}
		if(canAdded) {
			bookshelves[posShelve].addBook(ISBN, book);
		}
		return canAdded;
	}
	
	public void initializeStore(int cashiers, int shelves) {
		numberOfCashiers=cashiers;
		bookshelves = new Bookshelve[shelves];
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void addClients(Client newClient) {
		clients.add(newClient);
	}

	public int getNumberOfCashiers() {
		return numberOfCashiers;
	}


	public void setNumberOfCashiers(int numberOfCashiers) {
		this.numberOfCashiers = numberOfCashiers;
	}
	
	public boolean isClientsCatalog() {
		int incomplete = 0;
		for(int c = 0; c < getClients().size(); c++) {
			if(getClients().get(c).getStatus().equals("Catalog")) {
				incomplete++;
			}
		}
		if(incomplete > 0) {
			return true;
		}
		return false;
	}
	
	public boolean isClientsPickUp() {
		int catalog = 0;
		for(int c = 0; c < getClients().size(); c++) {
			if(getClients().get(c).getStatus().equals("Pick-Up")) {
				catalog++;
			}
		}
		if(catalog > 0) {
			return true;
		}
		return false;
	}

	public ArrayList<Book> getSpecificShelve(int position) {
		ArrayList<Book> observableList = new ArrayList<Book>();
		Node<String, Book>[] bookshelve = bookshelves[position].getBooksMap().getHashTable();
		for(Node<String, Book> book : bookshelve) {
			observableList.add(book.getValue());
		}
		return observableList;
	}
	
	public String getBookshelveName(int position) {
		return bookshelves[position].getName();
	}
	
	public Bookshelve[] getBookshelves() {
		return bookshelves;
	}

	public void setBookshelves(Bookshelve[] bookshelves) {
		this.bookshelves = bookshelves;
	}

}
