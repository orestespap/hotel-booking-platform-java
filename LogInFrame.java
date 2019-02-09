import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInFrame extends JFrame{
	
	private JPanel panel;
	private JPanel fieldpanel;

	private JTextField emailfield;
	private JPasswordField passwordfield;
	private JButton loginbutton;
	
	public LogInFrame() {
		

		panel=new JPanel();
		fieldpanel=new JPanel();
		
		emailfield=new JTextField("Email");
		passwordfield=new JPasswordField("Password");
		

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
		
		fieldpanel.add(emailfield);
		fieldpanel.add(passwordfield);
		fieldpanel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		loginbutton= new JButton("Log in!");
		loginbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonListener bl = new ButtonListener();
		loginbutton.addActionListener(bl);
		fieldpanel.add(loginbutton);
		
		panel.add(fieldpanel);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400, 400);
		this.setTitle("Log in!");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String nametext="";
			String surnametext="";
			String emailtext="";
			String passwordtext="";
			
		
			emailtext=emailfield.getText();
			passwordtext=new String (passwordfield.getPassword());
			
			if(emailtext.equals("") || emailtext.equals("Email") || passwordtext.equals("") || passwordtext.equals("Password")){
				JOptionPane.showMessageDialog(null,"Please type in both your password and your email!");
			}
			else {
				ArrayList<Customer> customersx=Database.getCustomers();
				boolean flag=true;
				
				for(Customer acustomer: customersx)
					if (acustomer.getEmail().equals(emailtext))
						if (acustomer.getPassword().equals(passwordtext)) {
							JOptionPane.showMessageDialog(null,"Welcome "+acustomer.getName()+"!");
							flag=false;
							LogInFrame.this.dispose();
							new DashboardFrame(acustomer);
							}
				if (flag)
					JOptionPane.showMessageDialog(null,"Wrong info. Please try again!");
			}
		}
	}
	
	
}
