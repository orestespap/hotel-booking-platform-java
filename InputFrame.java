import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputFrame extends JFrame {
	
	private JPanel panel;
	private JPanel diamoniPanel;
	private JPanel allInclusivePanel;
	private JPanel buttonPanel;
	
	private JLabel diamoniLabel;
	private JLabel hotelLabel;
	private JLabel allInclusiveLabel;
	
	private JList listView;
	private DefaultListModel model;
	
	private JTextField daysField;
	private JTextField mealsField;
	
	private JButton storeButton;
	private JButton calculateCostButton;
	private JButton hotelinfoButton;
	
	private JTextField costField;
	
	private ArrayList<Hotel> hotels;
	private Customer xcustomer;

	
	public InputFrame(Customer c) {
		
		xcustomer=c;
		hotels=Database.getHotels();
		panel = new JPanel();
		diamoniPanel = new JPanel();
		allInclusivePanel = new JPanel();
		buttonPanel = new JPanel();	
		
	
		listView = new JList();
		model = new DefaultListModel();
		

		HotelNameComparator hnc = new HotelNameComparator();
		
		Collections.sort(hotels,hnc);
		for(Hotel ahotel: hotels) {
			model.addElement(ahotel.getName());
		}
		
		
		
		listView.setModel(model);
		
		diamoniLabel = new JLabel("Stoixeia Diamonis");
		hotelLabel = new JLabel("Hotel");
		allInclusiveLabel = new JLabel("AllInclusive");
		
		daysField = new JTextField("Hmeres Diamonis");
		mealsField = new JTextField("Plithos Geumatwn (1,2,3)");
		costField = new JTextField("Synoliko Kostos");
		MouseListener aml = new AMouseListener();
		daysField.addMouseListener(aml);
		mealsField.addMouseListener(aml);
		costField.setEditable(false);
		
		storeButton = new JButton("Apothikeusi Kratisis");
		calculateCostButton = new JButton("Synoliko Kostos Kratisewn");
		hotelinfoButton = new JButton("Plhrofories xenodoxeiou");
		
		
		diamoniPanel.setLayout(new BoxLayout(diamoniPanel, BoxLayout.Y_AXIS));
		diamoniLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(diamoniLabel);
		hotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		diamoniPanel.add(hotelLabel);
		diamoniPanel.add(listView);
		diamoniPanel.add(daysField);
		diamoniPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		allInclusivePanel.setLayout(new GridLayout(2,0));
		allInclusivePanel.add(allInclusiveLabel);
		allInclusivePanel.add(mealsField);
		allInclusivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		buttonPanel.setLayout(new GridLayout(2,0));
		buttonPanel.add(storeButton);
		buttonPanel.add(calculateCostButton);
		buttonPanel.add(hotelinfoButton);
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		panel.add(diamoniPanel);
		panel.add(allInclusivePanel);
		panel.add(buttonPanel);
		panel.add(costField);
		
		this.setContentPane(panel);
		ButtonListener bl = new ButtonListener();
		storeButton.addActionListener(bl);
		calculateCostButton.addActionListener(bl);
		hotelinfoButton.addActionListener(bl);
		this.setVisible(true);
		this.setSize(200, 320);
		this.setLocation(200, 0);
		this.setTitle("Input");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Hotel selectedHotel= null;
			String selectedHotelName=(String)listView.getSelectedValue();
			Reservation res=null;
			
			for(Hotel hotel:hotels)
				if (hotel.getName().equals(selectedHotelName))
					selectedHotel=hotel;
			
			if (selectedHotel!=null)
				if(e.getSource().equals(storeButton)) {
				
						
						int days= Integer.parseInt(daysField.getText());
						String mealsText=mealsField.getText();
						
						if (selectedHotel.getAvailableRooms()>0) {
							if(selectedHotel.getAvailableRooms()==1)
								JOptionPane.showMessageDialog(null,"You are lucky! That was "+selectedHotel.getName()+"'s last room!");
				
							if (mealsText.equals("") || mealsText.equals("Plithos Geumatwn (1,2,3)")) {
								res = new Reservation(days,selectedHotel.getBasicCost());
					
								selectedHotel.addReservation(res);
								selectedHotel.parkARoom();
								xcustomer.addReservation(res);
								Database.addReservation(res);
								System.out.println("Basic "+selectedHotel.getName());
								}
			
							else{
								int noofmeals=Integer.parseInt(mealsField.getText());
								res = new AllInclusive(days,noofmeals,selectedHotel.getVIPCost(),selectedHotel.getCostPerMeal());
								
								selectedHotel.addReservation(res);
								selectedHotel.parkARoom();
								xcustomer.addReservation(res);
								Database.addReservation(res);
								System.out.println("VIP "+selectedHotel.getName());
					
							}
							
							
						
							InputFrame.this.addWindowListener(new WindowAdapter() {
								public void windowClosing(WindowEvent e) {
									SaveData.SaveReservations();
									SaveData.SaveCustomers();
						        
								}
							});
						}
						else {
							JOptionPane.showMessageDialog(null,selectedHotel.getName()+" has no available rooms!");
						}
					}
			  else if (e.getSource().equals(calculateCostButton)){
					costField.setText(Double.toString(selectedHotel.calculateTotalCost()));
				
			  		}
			  else {
				new HotelFrame(selectedHotel);
			  }
		
		}
	}
	
	class AMouseListener implements MouseListener{
		  @Override
		  public void mouseClicked(MouseEvent e) {
		   if (e.getSource().equals(mealsField))
			  mealsField.setText(""); 
		   else
			   daysField.setText("");
		  }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
}

