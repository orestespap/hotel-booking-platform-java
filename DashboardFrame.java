import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DashboardFrame extends JFrame{
	
	private JPanel panel;
	private JButton bookbutton;
	private JButton myreservbutton;
	private JButton myinfobutton;
	private JButton editinfobutton;
	private JButton logoutbutton;
	private Customer customerx;
	
	public DashboardFrame(Customer c) {
		customerx=c;
		
		panel= new JPanel();
		bookbutton=new JButton("Book a room");
		myreservbutton=new JButton("My reservations");
		myinfobutton=new JButton("My information");
		editinfobutton=new JButton("Edit information");
		logoutbutton= new JButton("Log out");
		
		MyBL bl = new MyBL();
		
		bookbutton.addActionListener(bl);
		myreservbutton.addActionListener(bl);
		myinfobutton.addActionListener(bl);
		editinfobutton.addActionListener(bl);
		logoutbutton.addActionListener(bl);
		
		panel.setLayout(new GridLayout(2,0));
		panel.add(bookbutton);
		panel.add(myreservbutton);
		panel.add(myinfobutton);
		panel.add(editinfobutton);
		panel.add(logoutbutton);
		
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(350, 350);
		this.setTitle(customerx.getName()+" dashboard");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	class MyBL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(myinfobutton))
				JOptionPane.showMessageDialog(null,"My information: "+System.lineSeparator()+customerx);
			else if (e.getSource().equals(myreservbutton))
			{ 
				JOptionPane.showMessageDialog(null,customerx.printReservations());
			}
			else if (e.getSource().equals(bookbutton))
				new InputFrame(customerx);
			else if (e.getSource().equals(editinfobutton))
				new EditInfoFrame(customerx);
			else
				DashboardFrame.this.dispose();
				
		}
		
		
	}

}
