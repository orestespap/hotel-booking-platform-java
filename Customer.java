import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Comparable, Serializable{
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private ArrayList<Reservation> reservations= new ArrayList<>();
	
	public Customer(String name, String surname, String email, String password) {
		this.name=name;
		this.surname=surname;
		this.email=email;
		this.password=password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void addReservation(Reservation r1) {
		reservations.add(r1);
		System.out.println("Reservation added!");
	}
	
	public ArrayList<Reservation> getreservations(){
		return reservations;
	}
	
	public void changeName(String aname) {
		name=aname;
	}
	
	public void changeSurname(String surn) {
		surname=surn;
	}
	public void changePassword(String pass) {
		password=pass;
	}
	
	public String printReservations() {
		String text="";
		for (Reservation ares: reservations)
			for (Hotel ahotel: Database.getHotels())
				for (Reservation ares2: ahotel.getReservations())
					if (ares.getID().equals(ares2.getID()))
						if (ares instanceof AllInclusive)
							text+=((AllInclusive)ares)+System.lineSeparator()+ahotel+System.lineSeparator()+"----------"+System.lineSeparator();
						else
							text+=ares+System.lineSeparator()+ahotel+System.lineSeparator()+"----------"+System.lineSeparator();
		if (text.equals(""))
			return "No reservations yet.";
		else
			return text;
	}

	@Override
	public String toString() {
		return "Name: "+getName()+System.lineSeparator()+"Surname: "+getSurname()+System.lineSeparator()+"Email: "+getEmail();
	}

	@Override
	public int compareTo(Object c2) {
		
		return ((Integer)reservations.size()). compareTo(((Integer)((Customer) c2).getreservations().size()));
	}
	

}
