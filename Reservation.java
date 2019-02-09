import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable{
	
	protected int days;
	protected int cost;
	protected Double id;
	
	public Reservation(int days, int cost) {
		this.days=days;
		this.cost=cost;
		
		ArrayList<Reservation> reservations=Database.getReservations();
		boolean flag=true;
		
		while (flag) {
			this.id=Math.floor((Math.random() * 400) + 1);
			Integer c=0;
			for(Reservation ares: reservations)
				if(!id.equals(ares.getID()))
					c+=1;
			if (c.equals(reservations.size()))
				flag=false;
		}
	}
	
	public Double getID() {
		return id;
	}
	
	public double calculateCost() {
		return days*cost;
	}
	
	@Override
	public String toString() {
		return "Reservation ID: "+getID()+System.lineSeparator()+"Total cost: "+calculateCost()+
				System.lineSeparator()+"Days: "+days;
	}

}
