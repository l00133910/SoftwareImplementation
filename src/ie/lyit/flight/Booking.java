package ie.lyit.flight;
import java.util.ArrayList;

public class Booking {
	//setting private fields for 
	//outbound and inbound flights
	//private field for total price
	//and setting counter to 0
	private Flight outbound;
	private Flight inbound;
	private double totalPrice;
	private static int count = 0;
	
	//private array list field for passengers
	private ArrayList<Passenger> passengers;
	
	//default constructor for booking using (this) so that the correct objects are selected
	public Booking(){
		this.inbound = new Flight();
		this.outbound = new Flight();
		this.passengers = new  ArrayList<Passenger>();
		this.totalPrice = 0;
		//adds 1 to counter as each new passenger is added in
		count  = count++;
	}
	
	// Initialization Constructor
	//initializing flight oF, FLight iF and the passenger arrayList
	public Booking(Flight oF, Flight iF, ArrayList<Passenger> p){

		outbound = oF;
		inbound = iF;
		totalPrice = 0;//set total price at a starting point of Zero
		count++;
		passengers = p;//initializing passenger ARRAYLIST
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return "Outbound Flight: " + outbound + " " + "Inbound Flight: "+ inbound +" "+"Total Price: "+ totalPrice + " " + "Cound: "+ count + " " +"Passenger Name: " +passengers + " ";
	}
	
	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(e1.equals(e2))				
	// ==> Probably sufficient to compare passenger bookings as they're unique
	@Override
	public boolean equals(Object obj){
		Booking bObject;
		if (obj instanceof Booking)
		   bObject = (Booking)obj;
		else
		   return false;
		   
		return this.outbound.equals(bObject.outbound) &&
				this.inbound.equals(bObject.inbound) &&
				this.passengers.equals(bObject.passengers);							
			}
	
	//finding the passenger if they exsist
	//If the do not exsit nothing will be returned
	public boolean findPasenger(Passenger p, ArrayList<Passenger>passengers) {
		return passengers.contains(p);
	}
	
	//calcaulate total customer price by adding the inbound price with the outbound price and number
	// of passengers - (OR SIZE)
	public double calculatePrice() {
		return totalPrice = (inbound.getPrice()+outbound.getPrice())* passengers.size();		
	}
	
	//methods
	//getters and setters for booking
	//set outbound flight
	public void setOutbound(Flight outboundIn){
	    this.outbound=outboundIn;
	}
	
	//get outbound flight
	public Flight getOutbound(){
	   return outbound;
    }
	//set inbound flight
	public void setInbound(Flight inboundIn){
		this.inbound=inboundIn;
	}
	
	//get inbound flight
	public Flight getInbound(){
	   return inbound;
    }	
	
	//set and get price 
	//calculate the total price
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = calculatePrice();
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	
	//getPassenger from arrayList
	public ArrayList<Passenger>getPassengers(){
		return passengers;
	}
	//setPassengers from array list
	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	//number of passengers calcultated by using the count++ 
	public void setCount(int count) {
		this.count = count;
	}
	public static int getCount() {
		return count;
	}
	

	
}
