import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpFrame extends JFrame{
	
	private JPanel panel;
	private JPanel fieldpanel;
	private JTextField namefield;
	private JTextField surnamefield;
	private JTextField emailfield;
	private JTextField passwordfield;
	private JButton okbutton;
	
	public SignUpFrame() {
		

		panel=new JPanel();
		fieldpanel=new JPanel();
		
		namefield= new JTextField("Name");
		surnamefield=new JTextField("Surname");
		emailfield=new JTextField("Email");
		passwordfield=new JTextField("Password");
		
		namefield.addMouseListener(new MouseAdapter(){
			int c=0;
            @Override
            public void mouseClicked(MouseEvent e){
                if (c==0)
                	namefield.setText("");
                c+=1;
            }
        });
		surnamefield.addMouseListener(new MouseAdapter(){
			int c=0;
            @Override
            public void mouseClicked(MouseEvent e){
            	if (c==0)
            		surnamefield.setText("");
            	c+=1;
            }
        });
		emailfield.addMouseListener(new MouseAdapter(){
            int c=0;
			@Override
            public void mouseClicked(MouseEvent e){
                if (c==0)
                	emailfield.setText("");
                c+=1;
            }
        });
		passwordfield.addMouseListener(new MouseAdapter(){
			int c=0;
            @Override
            public void mouseClicked(MouseEvent e){
				if (c==0)
					passwordfield.setText("");
				c+=1;
			}
        });
	
		fieldpanel.setLayout(new BoxLayout(fieldpanel, BoxLayout.Y_AXIS));
		
		fieldpanel.add(namefield);
		fieldpanel.add(surnamefield);
		fieldpanel.add(emailfield);
		fieldpanel.add(passwordfield);
		fieldpanel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		okbutton= new JButton("OK!");
		okbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonListener bl = new ButtonListener();
		okbutton.addActionListener(bl);
		fieldpanel.add(okbutton);
		
		panel.add(fieldpanel);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Sign up!");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String nametext="";
			String surnametext="";
			String emailtext="";
			String passwordtext="";
			
			nametext=namefield.getText();
			surnametext=surnamefield.getText();
			emailtext=emailfield.getText();
			passwordtext=passwordfield.getText();
			
			if( nametext.equals("") || nametext.equals("Name") || surnametext.equals("") || surnametext.equals("Surname") ||
				emailtext.equals("") || emailtext.equals("Email") || passwordtext.equals("") || passwordtext.equals("Password")){
				JOptionPane.showMessageDialog(null,"Please fill out all the fields!");
			}
			else {
				ArrayList<Customer> customersx=Database.getCustomers();
				boolean flag=false;
				
				if (customersx!=null)
					for(Customer acustomer: customersx)
						if (acustomer.getEmail().equals(emailtext)) {
							JOptionPane.showMessageDialog(null,emailtext+" has been used! Try a different email!");
							flag=true;
							break;
						}
				if(!flag) {
					Customer c = new Customer(nametext,surnametext,emailtext,passwordtext);
					Database.addCustomer(c);
					JOptionPane.showMessageDialog(null,"Account successfully created!"+System.lineSeparator()+"Information: "+
					System.lineSeparator()+c.toString());
					SaveData.SaveCustomers();
					SignUpFrame.this.dispose();
				}
			}
			
		
		}
	}
	
	
}
