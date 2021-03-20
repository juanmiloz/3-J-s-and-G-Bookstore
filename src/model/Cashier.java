package model;

public class Cashier {
	
	private Boolean occupied; 
	private Client current;
    private String bag;
    private double price;
    
	
	public Cashier() {
		occupied = false;
        current = null;
        bag = "";
        price = 0; 
    }
    

    public void begin(Client newClient){
        occupied = true;
        current = newClient;
        bag = "";
        price = 0; 
    } 

    public void advance(){
        Book popped=current.getSortedBookBaskets().pop();
        bag+= popped.getISBN()+" ";
        price+=popped.getPrice();
        if(current.getSortedBookBaskets().isEmpty()){
            occupied=false; 
       }
    }
    
    public String report(){
        String info="";
        info+= "Client ID: "+ current.getId() + "Final Price: "+ price + "\n";
        info+= "Books in Bag: " +bag+  "\n";
        return info;
    }

	public Boolean getOccupied() {
		return occupied;
	}
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	
	public Client getCurrent() {
		return current;
	}
	
	public void setCurrent(Client newCurrent) {
		this.current = newCurrent;
	}
		
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

    
	
}