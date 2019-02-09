import java.io.Serializable;
import java.util.ArrayList;


public class Hotel implements Serializable {
	
	private String name;
	private int availablerooms;
	private int basiccost;
	private int vipcost;
	private int costpermeal;
	private ArrayList<Reservation> reservations;
	
	public Hotel(String name,int rooms, int basic, int vip, int costpermeal) {
		this.name = name;
		this.availablerooms=rooms;
		this.basiccost=basic;
		this.vipcost=vip;
		this.costpermeal=costpermeal;
		this.reservations= new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Reservation> getReservations(){
		return reservations;
	}
	
	public void addReservation(Reservation r1) {
		reservations.add(r1);
	}
	
	public int getBasicCost() {
		return basiccost;
	}
	
	public int getVIPCost() {
		return vipcost;
	}
	
	public int getCostPerMeal() {
		return costpermeal;
	}
	
	public void changeBasicCost(int x){
		basiccost=x;
	}
	
	public void changeVIPCost(int x){
		vipcost=x;
	}
	
	public void parkARoom() {
		availablerooms-=1;
	}
	
	public void freeupARoom() {
		availablerooms-=1;
	}
	
	public int getAvailableRooms() {
		return availablerooms;
	}
	
	public double calculateTotalCost() {
		double sum=0;
		
		for (Reservation ares: reservations)
			sum+=ares.calculateCost();
		return sum;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}



