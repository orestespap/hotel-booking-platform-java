import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
	
	private static ArrayList<Customer> customers=new ArrayList<Customer>();
	private static ArrayList<Hotel> hotels=new ArrayList<Hotel>();
	private static ArrayList<Reservation> reservations=new ArrayList<Reservation>();
	
	public static void addCustomer(Customer acustomer) {
		customers.add(acustomer);
		System.out.println("Customer added!");
	}
	
	public static void addReservation(Reservation r1) {
		reservations.add(r1);
		System.out.println("Reservation added!");
	}
	
	public static void addHotel(Hotel h1) {
		hotels.add(h1);
		System.out.println("Hotel added!");
	}
	
	public static ArrayList<Customer> getCustomers(){
		return customers;
	}
	
	public static ArrayList<Hotel> getHotels(){
		return hotels;
	}
	
	public static ArrayList<Reservation> getReservations(){
		return reservations;
	}
	
	
	public static void addCustomers(ArrayList<Customer> clist){
		customers=clist;
	}
	public static void addHotels(ArrayList<Hotel> hlist){
		hotels=hlist;
	}
	
	public static void addReservations(ArrayList<Reservation> rlist){
		reservations=rlist;
	}
}
