import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private JPanel panel;
	private JPanel buttonPanel;
	private JLabel mainlabel;
	
	private JButton loginbutton;
	private JButton signupbutton;

	
	public MainFrame() {
		
	
		Database.addCustomers(GetData.getCustomers());
		Database.addReservations(GetData.getReservations());
		Database.addHotels(GetData.getHotels());
		
		
		panel = new JPanel();
		buttonPanel=new JPanel();
		
		loginbutton= new JButton("Log in");
		signupbutton= new JButton("Sign up");
		
		loginbutton.setPreferredSize(new Dimension(150,30));
		
		
		mainlabel= new JLabel("Welcome to Booking.com!");
		mainlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(mainlabel);
	
		
		buttonPanel.setLayout(new GridLayout(2,0));
		buttonPanel.add(loginbutton);
		buttonPanel.add(signupbutton);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.add(buttonPanel);
		
		this.setContentPane(panel);
		ButtonListener bl = new ButtonListener();
		loginbutton.addActionListener(bl);
		signupbutton.addActionListener(bl);
		this.setVisible(true);
		this.setSize(200, 320);
		this.setLocation(200, 0);
		this.setTitle("Welcome");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    	SaveData.SaveCustomers();
		    	SaveData.SaveHotels();
		    	SaveData.SaveReservations();
		    }
		});
		
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(loginbutton))
				new LogInFrame();
	
			else 
				new SignUpFrame();
		}
	}
}
