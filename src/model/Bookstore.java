package model;

import java.util.ArrayList;

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

	public ArrayList<Book> getSpecificShelve(int position) {
		ArrayList<Book> observableList = new ArrayList<Book>();
		//Falta código para obtener los libros de una estantería y retornarlos
		
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
