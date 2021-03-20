package model;

public class Cashier {
	
	private Boolean occupied; 
	private Client current;
    private String bag;
    private double price;
    
	/**
	 * Name: Cashier
	 * Constructor method of a cashier. <br>
	 */
	public Cashier() {
		occupied = false;
        current = null;
        bag = "";
        price = 0; 
    }
    
	/**
	 * Name: begin
	 * Method to initialize the class . <br>
	 * @param newClient - newClient = Client, newClient != null
	 */
    public void begin(Client newClient){
        occupied = true;
        current = newClient;
        bag = "";
        price = 0; 
    } 
    /**
	 * Name: advance
	 * method to advance to the next  . <br>
     */
    public void advance(){
        Book popped=current.getSortedBookBaskets().pop();
        bag+= popped.getISBN()+" ";
        price+=popped.getPrice();
        if(current.getSortedBookBaskets().isEmpty()){
            occupied=false; 
       }
    }
    /**
	 * Name: report
	 * Method to get the sale report . <br>
     * @return String whit the sale report
     */
    public String report(){
        String info="";
        info+= "Client ID: "+ current.getId() + "Final Price: "+ price + "\n";
        info+= "Books in Bag: " +bag+  "\n";
        return info;
    }
	/**
	 * Name: getOccupied
	 * Method used to get if stay occupied. <br>
	 * @return A boolean  representing if stay occupied.
	*/
	public Boolean getOccupied() {
		return occupied;
	}
	/**
	 * Name: setOccupied
	 * Method used to update if stay occupied.  <br>
	 * @param ocuppied - stay occupied - ocuppied = boolean
	*/
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	/**
	 * Name: getCurrent
	 * Method used to get current client. <br>
	 * @return A Client representing current client.
	*/
	public Client getCurrent() {
		return current;
	}
	/**
	 * Name: setCurrent
	 * Method used to update current client.  <br>
	 * @param newCurrent - current client - newCurrent = Client
	*/
	public void setCurrent(Client newCurrent) {
		this.current = newCurrent;
	}
	/**
	 * Name: getPrice
	 * Method used to get sale price. <br>
	 * @return A double representing sale price.
	*/
	public double getPrice() {
		return price;
	}
	/**
	 * Name: setPrice
	 * Method used to update sale price.  <br>
	 * @param price - sale price - price = double
	*/
	public void setPrice(double price) {
		this.price = price;
	}

    
	
}