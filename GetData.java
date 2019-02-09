import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GetData {
	
	public static ArrayList<Customer> getCustomers(){
		
		ArrayList<Customer> customers = new ArrayList<>();
		File file= new File("customers.ser");
		try {
			FileInputStream filein= new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(filein);
			
			customers=(ArrayList<Customer>)in.readObject();
			in.close();
			filein.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	
	public static ArrayList<Hotel> getHotels(){
		
		ArrayList<Hotel> hotels = new ArrayList<>();
		File file= new File("hotels.ser");
		try {
			FileInputStream filein= new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(filein);
			
			hotels=(ArrayList<Hotel>)in.readObject();
			in.close();
			filein.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotels;
	} 

	public static ArrayList<Reservation> getReservations(){
		ArrayList<Reservation> reservations = new ArrayList<>();
		File file= new File("reservations.ser");
		try {
			FileInputStream filein= new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(filein);
		
			reservations=(ArrayList<Reservation>)in.readObject();
			in.close();
			filein.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservations;
}

}
