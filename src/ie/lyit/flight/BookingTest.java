package ie.lyit.flight;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

//JUnit Page so that we can test all of the methods correctly
public class BookingTest {
	
	//initializing fields from booking.java page
	private ArrayList<Passenger> passengers;
	private Booking passengerBookingObj1;
	private Flight outbound;
	private Flight inbound;
	
	//setting the passenger and all of the fields for inbound, outbound flights and dates
	@Before
	public void setUp() throws Exception {
		//getting flight details
		outbound = new Flight("AerLingus","Carrickfinn","Glasgow",01,02,2019,10,02,2019);
		inbound = new Flight("AerLingus","Glasgow","Glasgow",10,02,2019,01,02,2019);
		//adding passenger and personal details from "passport"
		passengers= new ArrayList<Passenger>();
		passengers.add(new Passenger("Mr","Shane","Gillespie",10,12,1997,10,true));
		//passengerBookingObj1 is the object of the new passenger
		passengerBookingObj1 = new Booking(outbound, inbound, passengers);
	}
	
	@Test
	public void testBookingFlightFlightArrayListOfPassenger() {
		assertEquals(passengers,passengerBookingObj1.getPassengers());
		assertEquals(outbound,passengerBookingObj1.getOutbound());
		assertEquals(inbound,passengerBookingObj1.getInbound());
		//fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		String booking = "Outbound: " + outbound + "Inbound: "+inbound+ "Total Price: "+passengerBookingObj1.getTotalPrice()+"Passenger: " +passengers;
		assertEquals(booking,passengerBookingObj1.toString());
		//fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		Booking passengerBookingObj2=new Booking();
		assertFalse(passengerBookingObj1.equals(passengerBookingObj2));
		//fail("Not yet implemented");
	}

	@Test
	public void testFindPasenger() {
		assertTrue(passengerBookingObj1.findPasenger(new Passenger("Mr","Shane","Gillespie",10,12,1997,10,true),passengers));
		//fail("Not yet implemented");
	}

	@Test
	public void testCalculatePrice() {
		double total=(inbound.getPrice()+outbound.getPrice())*passengers.size();
		assertEquals(total,passengerBookingObj1.calculatePrice(),0.001);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetOutbound() {
		Flight newFlightObj = new Flight ("AerLingus", "Carrickfinn", "Donegal",01,02,2019,10,02,2019);
		passengerBookingObj1.setOutbound(newFlightObj);
		//fail("Not yet implemented");
	}


	@Test
	public void testSetInbound() {
		Flight newFlightObj = new Flight ("AerLingus", "Donegal", "Carrickfinn",10,02,2019,01,02,2019);
		passengerBookingObj1.setOutbound(newFlightObj);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetTotalPrice() {
		passengerBookingObj1.getTotalPrice();
		double total=(inbound.getPrice()+outbound.getPrice())*passengers.size();
		assertEquals(total,passengerBookingObj1.getTotalPrice(),0.001);
		//fail("Not yet implemented");
	}


}
