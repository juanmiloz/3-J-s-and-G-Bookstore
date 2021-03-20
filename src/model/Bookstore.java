package model;

import java.util.ArrayList;
import java.util.Collections;

import structures.queue.*;
import structures.hashTable.Node;

public class Bookstore {


	private int bookCount;
	private Bookshelve[] bookshelves;
	private ArrayList<Client> clients;
	private  Queue<Client> checkoutLine;
	private Cashier[] cashiers;

	/**
	 * Name : Bookstore
	 * Constructor method of a bookstore. <br>
	 */
	public Bookstore() {
		clients = new ArrayList<>();
		checkoutLine=new Queue<>();
		bookCount=0;
	}
	/**
	 * Name: initializateBookshelves
	 * Method used to initialize the bookshelf  <br>
	 * @param position - the position in the bookshelf - position = int
	 * @param booksQuantity - quantity of books - booksQuantity = int
	 * @param name - name of the bookshelf - name = String, name != null, name != ""
	 */
	public void initializateBookshelves(int position, int booksQuantity, String name) {
		bookshelves[position] = new Bookshelve(booksQuantity);
		bookshelves[position].setName(name);
	}
	/**
	 * Name: addBook
	 * Method for adding a new book to the bookshelf  <br>
	 * @param ISBN - ISBN's book - ISBN = String, ISBN != null, ISBN != ""
	 * @param book - book to add - book!= null
	 * @param posShelve - position  - posShelve = int
	 * @return a boolean informing if the book was added 
	 */
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
			bookCount++;
		}
		return canAdded;
	}



	public void initializeCheckOutLine(){
		Collections.sort(clients);
		
		for(int i=0; i< clients.size(); i++){
			System.out.println(clients.get(i).getTime());
			checkoutLine.enqueue(clients.get(i));
		}
	}

	public void checkout(){
		String report="";
		while(!checkoutLine.isEmpty()){
			for(int i=0; i< cashiers.length; i++){
				if(!cashiers[i].getOccupied()){
					cashiers[i].begin(checkoutLine.dequeue());
				}else{
					cashiers[i].advance();
					if(!cashiers[i].getOccupied()){
						report+=cashiers[i].report();
					}
				}
			} 
		}
		System.out.println(report);
	}

	/**
	 * Name: addBook
	 * Method to initialize the bookstore  <br>
	 * @param cash - number of cashiers - cashiers = int
	 * @param shelves - quantity of shelves - shelves = int
	 */
	public void initializeStore(int cash, int shelves) {
		cashiers= new Cashier[cash];
		for(int i=0; i<cash;i++){
			cashiers[i]= new Cashier();
		}
		bookshelves = new Bookshelve[shelves];
	}
	/**
	 * Name: getClients
	 * Method used to get the list of clients. <br>
	 * @return A ArrayList<Client> representing the list of clients.
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	public void addClients(Client newClient) {
		clients.add(newClient);
	}
	/**
	 * Name: getCashiers
	 * Method used to get  cashiers. <br>
	 * @return An array representing cashiers.
	 */
	public Cashier[] getCashiers() {
		return cashiers;
	}

	/**
	 * Name: setCashiers
	 * Method used to update the cashiers.  <br>
	 * @param cashiers - cashiers array - cashiers = int
	*/
	public void setCashiers(Cashier[] Cashiers) {
		this.cashiers = cashiers;
	}
	/**
	 * Name: isClientsCatalog
	 * Method to check if it is the customer catalog  <br>
	 * @return a boolean 
	 */
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
	/**
	 * Name: getBookshelveName
	 * Method used to get a specific shelf . <br>
	 * @param position - position of shelf - position = int
	 * @return a ArrayList<Book> with selected shelf 
	 */
	public ArrayList<Book> getSpecificShelve(int position) {
		ArrayList<Book> observableList = new ArrayList<>();
		Node<String, Book>[] bookshelve = bookshelves[position].getBooksMap().getHashTable();
		//System.out.println(bookshelve);
		
		//Map.Entry mapElement : hm.entrySet()
		
		//bookshelveMap.getValue(isbn)
		
			for(int i=0; i<bookshelve.length;i++) {
				Node<String, Book> current= bookshelve[i];
				
				while(current!=null) {
					observableList.add(current.getValue());
					current=current.getNext();
				}
				
			}
			
			
		
		
		
		
		
		return observableList;
	}
	/**
	 * Name: getBookshelveName
	 * Method used to get name of bookshelf. <br>
	 * @return A int representing position of the bookshelf.
	 */
	public String getBookshelveName(int position) {
		return bookshelves[position].getName();
	}
	/**
	 * Name: getBookshelves
	 * Method used to get list of bookshelfs. <br>
	 * @return A Bookshelve[] representing bookshelfs.
	 */
	public Bookshelve[] getBookshelves() {
		return bookshelves;
	}
	/**
	 * Name: setBookshelves
	 * Method used to update the list of bookshelves.  <br>
	 * @param bookshelves - bookshelves  - bookshelves = Bookshelve[], bookshelves != null
	*/
	public void setBookshelves(Bookshelve[] bookshelves) {
		this.bookshelves = bookshelves;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public Queue<Client> getCheckoutLine() {
		return checkoutLine;
	}
	public void setCheckoutLine(Queue<Client> checkoutLine) {
		this.checkoutLine = checkoutLine;
	}

	

}
