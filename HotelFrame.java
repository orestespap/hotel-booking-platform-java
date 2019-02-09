import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HotelFrame extends JFrame {
	
	private JPanel panel;
	private Hotel hotelx;
	private JLabel hotelnamelabel;
	private JLabel resinfolabel;
	
	public HotelFrame(Hotel ahotel) {
		this.hotelx=ahotel;
		panel= new JPanel();
		
		JTextField hotelname=new JTextField();
		hotelname.setText(hotelx.getName());
		hotelname.setEditable(false);
		hotelname.setPreferredSize(new Dimension(100,100));
		
		JTextField avrooms = new JTextField("Available rooms: "+hotelx.getAvailableRooms());
		avrooms.setEditable(false);
		avrooms.setPreferredSize(new Dimension(100,100));
		
		JTextArea hotelreservations= new JTextArea();
		String restext="";
		int i=0;
		
		for (Reservation ares: hotelx.getReservations()) {
			i+=1;
			if (ares instanceof AllInclusive) {
				restext+="Reservation "+i+" cost: "+Double.toString(ares.calculateCost())+" euro, with "+Integer.toString(((AllInclusive)ares).getmeals())+" meals.";
				restext+=System.lineSeparator();
			}
			else {
				restext+="Reservation "+i+" cost: "+Double.toString(ares.calculateCost())+" euro.";
				restext+=System.lineSeparator();
			}
		}
		
		if(restext.equals(""))
			restext="No reservations!";
		hotelreservations.setText(restext);
		hotelreservations.setPreferredSize(new Dimension(275,275));
		hotelreservations.setEditable(false);
		hotelreservations.setBackground(Color.WHITE);
		
		hotelnamelabel=new JLabel("Hotel name");
		resinfolabel=new JLabel("Reservations");
		panel.add(hotelnamelabel);
		panel.add(hotelname);
		panel.add(avrooms);
		panel.add(resinfolabel);
		panel.add(hotelreservations);
		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Hotel reservation info");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}

}
