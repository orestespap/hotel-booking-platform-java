import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveData {
	
	
	public static void SaveHotels() {
		try {
			FileOutputStream fileOut = new FileOutputStream("hotels.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Database.getHotels());
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		
	}
	
	public static void SaveReservations() {
		try {
			FileOutputStream fileOut = new FileOutputStream("reservations.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Database.getReservations());
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		
	}
	
	public static void SaveCustomers() {
		try {
			FileOutputStream fileOut = new FileOutputStream("customers.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Database.getCustomers());
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		
	}

}
