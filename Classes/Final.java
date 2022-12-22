package Classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Final implements ActionListener
{
	static User u;
	
	JFrame f;
	
	ImageIcon i1,i2;
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	
	JButton b1,b2,b3;
	
	Final(User a)
	{
		u = a;
		
		f = new JFrame();
		
		i1 = new ImageIcon("Images/nice.jpg");
		i2 = new ImageIcon("Images/nice1.jpg");
		
		l1 = new JLabel();
		l1.setIcon(i1);
		l1.setBounds(0,0,1124,633);
		
		l2 = new JLabel("Account Info: ");
		l2.setBounds(700,280,270,30);
		l2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		l2.setForeground(new Color (255,254,237));
		
		l3 = new JLabel("Gender: "+u.getGender());
		l3.setBounds(700,380,350,30);
		l3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l3.setForeground(new Color (255,254,237));
		
		l4 = new JLabel("Contact Number: "+u.getContactNum());
		l4.setBounds(700,410,350,30);
		l4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l4.setForeground(new Color (255,254,237));
		
		l5 = new JLabel("Major: "+u.getMajor());
		l5.setBounds(700,440,350,30);
		l5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l5.setForeground(new Color (255,254,237));
		
		l6 = new JLabel("Certificates: "+u.degrees.toString().replace("[","").replace("]", ""));
		l6.setBounds(700,470,350,30);
		l6.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l6.setForeground(new Color (255,254,237));
		
		l7 = new JLabel("Full name: "+u.getName());
		l7.setBounds(700,320,350,30);
		l7.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l7.setForeground(new Color (255,254,237));
		
		l8 = new JLabel("Username: "+u.getUserName());
		l8.setBounds(700,350,350,30);
		l8.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l8.setForeground(new Color (255,254,237));
		
		b1 = new JButton("Pervious");  
        b1.setBounds(17,15,85,25);  
        b1.addActionListener(this);
        
        b2 = new JButton("Exit");  
        b2.setBounds(1000,15,85,25);  
        b2.addActionListener(this);
        
        b3 = new JButton("Logout");  
        b3.setBounds(790,510,85,25);  
        b3.addActionListener(this);
		
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(l7);
        f.add(l8);
		f.add(l1);
		
		f.setSize(1124,633);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("You have reached the end");
		f.setIconImage(i2.getImage());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			new Update(u);
			f.setVisible(false);
		}
		
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		
		if(e.getSource()==b3)
		{
			new Login(u);
			f.setVisible(false);
		}
	}
}
