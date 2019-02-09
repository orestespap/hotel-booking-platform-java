import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EditInfoFrame extends JFrame {
	private Customer c;
	private JPanel panel;
	private JPanel fieldpanel;
	private JTextField namefield;
	private JTextField surnamefield;
	private JPasswordField passwordfield;
	private JTextField newpassfield1;
	private JTextField newpassfield2;
	private JButton savebutton;
	
	
	public EditInfoFrame(Customer acustomer) {
		c=acustomer;
		
		panel = new JPanel();
		fieldpanel=new JPanel();
		
		namefield= new JTextField("Name");
		surnamefield= new JTextField("Surname");
		passwordfield=new JPasswordField("Password");
		newpassfield1= new JTextField("New password");
		newpassfield2= new JTextField("New password");
		
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
		passwordfield.addMouseListener(new MouseAdapter(){
			int c=0;
            @Override
            public void mouseClicked(MouseEvent e){
				if (c==0)
					passwordfield.setText("");
				c+=1;
			}
        });
		
		newpassfield1.addMouseListener(new MouseAdapter(){
            int c=0;
			@Override
            public void mouseClicked(MouseEvent e){
                if (c==0)
                	newpassfield1.setText("");
                c+=1;
            }
        });
		
		newpassfield2.addMouseListener(new MouseAdapter(){
            int c=0;
			@Override
            public void mouseClicked(MouseEvent e){
                if (c==0)
                	newpassfield2.setText("");
                c+=1;
            }
        });
		
		savebutton= new JButton("Save changes");
		savebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String passwordtext= new String(passwordfield.getPassword());
				if (namefield.getText().equals("") || surnamefield.getText().equals("")
					|| passwordtext.equals("Current password") || passwordtext.equals("") || newpassfield1.getText().equals("")
					|| newpassfield2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in all the fields that you have clicked on.");
				}
				else if(!c.getPassword().equals(passwordtext))
					JOptionPane.showMessageDialog(null,"Wrong password!");
				else if (!newpassfield1.getText().equals(newpassfield2.getText()))
					JOptionPane.showMessageDialog(null,"Retype of new password must match new password");
				else if(c.getPassword().equals(newpassfield2.getText()))
					JOptionPane.showMessageDialog(null,"New password can't be the same as the previous one. GDPR!");
				else {
					if (!namefield.getText().equals("Name"))
						c.changeName(namefield.getText());
					if (!surnamefield.getText().equals("Surname"))
						c.changeSurname(surnamefield.getText());
					if (!newpassfield2.getText().equals("New password"))
						c.changePassword(newpassfield2.getText());	
					JOptionPane.showMessageDialog(null,"Changes saved successfully!");
					EditInfoFrame.this.dispose();
				}
			}});
		
		fieldpanel.setLayout(new BoxLayout(fieldpanel, BoxLayout.Y_AXIS));
		
		fieldpanel.add(passwordfield);
		fieldpanel.add(namefield);
		fieldpanel.add(surnamefield);
		fieldpanel.add(newpassfield1);
		fieldpanel.add(newpassfield2);
		fieldpanel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		
		savebutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		fieldpanel.add(savebutton);
		
		panel.add(fieldpanel);
		this.setContentPane(panel);
		this.setTitle("Edit information.");
		this.setVisible(true);
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
