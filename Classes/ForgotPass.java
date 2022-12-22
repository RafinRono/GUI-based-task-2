package Classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ForgotPass implements ActionListener
{
	User u;

	JFrame f;
	
	ImageIcon i1, i2;
	
	JLabel l1,l2;
	
	JButton b1, b2, b3;
	
	JTextField tf1;
	
	ForgotPass(User a)
	{
		u=a;

		f = new JFrame();
		
		i1 = new ImageIcon("Images/ez.jpg");
		i2 = new ImageIcon("Images/ez1.jpg");
		
		l1 = new JLabel();
		l1.setIcon(i1);
		l1.setBounds(0,0,1124,633);
		
		l2 = new JLabel("Enter existing user name:");
		l2.setBounds(650,200,270,20);
		l2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		l2.setForeground(new Color (255,254,237));
		
		tf1 = new JTextField();
		tf1.setBounds(885,203,180,20);
		
		b1 = new JButton("Check");
		b1.setBounds(820,235,70,20);
		b1.addActionListener(this);
		
		b2 = new JButton("Pervious");  
        b2.setBounds(17,15,85,25);  
        b2.addActionListener(this);
        
        b3 = new JButton("Exit");  
        b3.setBounds(1000,15,85,25);  
        b3.addActionListener(this);
		
		f.add(tf1);
		f.add(l2);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(l1);
		
		f.setSize(1124,633);
		f.setResizable(false);
		f.setTitle("Forgot Password?");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(i2.getImage());
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==b1)
		{
			String a = tf1.getText();
			
			String oldPass = Login.forgetPass(a);
			
			if(oldPass != null)
			{
				JOptionPane.showMessageDialog(null, "Your password is: "+oldPass);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Your username was not found.");
			}
		}
		
		if (e.getSource()==b2)
		{
			new Login(u);
			f.setVisible(false);
		}
		
		if (e.getSource()==b3)
		{
			System.exit(0);
		}
	}
}