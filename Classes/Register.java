package Classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Register implements ActionListener 
{
	User u;

	JFrame f;
	
	ImageIcon i1,i2;
	
	JLabel l1,l2,l3,l4,l5;
	
	JTextField tf1, tf2;
	
	JPasswordField pf1;
	
	JButton b1, b2, b3;
	
	Register(User a)
	{
		u=a;
		
		f = new JFrame();
		
		i1 = new ImageIcon("Images/owo.jpg");
		i2 = new ImageIcon("Images/owo1.jpg");
		
		l1 = new JLabel();
		l1.setIcon(i1);
		l1.setBounds(0,0,1124,633);
		
		l2 = new JLabel("Please fill up all the fields accordingly:");
		l2.setBounds(600, 300, 400, 20);
		l2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		l2.setForeground(new Color (255,254,237));
		
		l3 = new JLabel("Full name:");
		l3.setBounds(600, 340, 200, 20);
		l3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		l3.setForeground(new Color (255,254,237));
		
		l4 = new JLabel("New user name:");
		l4.setBounds(600, 370, 200, 20);
		l4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		l4.setForeground(new Color (255,254,237));
		
		l5 = new JLabel("New Password:");
		l5.setBounds(600, 400, 200, 20);
		l5.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		l5.setForeground(new Color (255,254,237));
		
		tf1 = new JTextField();
		tf1.setBounds(735,343,150,20);
		
		tf2 = new JTextField();
		tf2.setBounds(735,373,150,20);
		
		pf1 = new JPasswordField();
		pf1.setBounds(735,403,150,20);
		
		b1 = new JButton("Pervious");  
        b1.setBounds(17,15,85,25);  
        b1.addActionListener(this);
        
        b2 = new JButton("Exit");  
        b2.setBounds(1000,15,85,25);  
        b2.addActionListener(this);
        
        b3 = new JButton("Register");  
        b3.setBounds(715,435,85,25);  
        b3.addActionListener(this);
		
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(tf1);
		f.add(tf2);
		f.add(pf1);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(l1);
		
		f.setSize(1124,633);
		f.setTitle("Want to make an account?");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(i2.getImage());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			new Login(u);
			f.setVisible(false);
		}
		
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		
		if(e.getSource()==b3)
		{
			String a = tf1.getText();
			String b = tf2.getText();
			String c = String.valueOf(pf1.getPassword());
			
			User u=null;
			
			if((a.isEmpty()!=true) && (b.isEmpty()!=true) && (c.isEmpty()!=true))
			{
				u = new User(b,c,a);
				
				if(Login.searchUser(u)!=null)
				{
					JOptionPane.showMessageDialog(null,"an user already exists with that username");
				}
				else
				{
					Login.addUser(u);
					f.setVisible(false);
					new Login(u);
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Please fill all the fields properly");
			}
		}
	}
}
