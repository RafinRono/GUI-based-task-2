package Classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Home implements ActionListener
{
	static User u;
	
	JFrame f;
	
	ImageIcon i1,i2;
	
	JLabel l1,l2,l3;
	
	JButton b1,b2,b3,b4;
	
	Home(User a)
	{
		u = a;
		
		f = new JFrame();
		
		i1 = new ImageIcon ("Images/oko1.jpg");
		i2 = new ImageIcon ("Images/oko2.jpg");
		
		l1 = new JLabel();
		l1.setIcon(i1);
		l1.setBounds(0,0,1124,633);
		
		l2 = new JLabel("Welcome, "+a.getName());
		l2.setBounds(440,200,400,30);
		l2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		l2.setForeground(new Color (255,254,237));
		
		l3 = new JLabel("Click \"next\" to update your info.");
		l3.setBounds(420,300,350,30);
		l3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l3.setForeground(new Color (255,254,237));
		
		b1 = new JButton("Pervious");  
        b1.setBounds(17,15,85,25);  
        b1.addActionListener(this);
        
        b2 = new JButton("Exit");  
        b2.setBounds(1000,15,85,25);  
        b2.addActionListener(this);
        
        b3 = new JButton("Next");  
        b3.setBounds(533,345,85,25);  
        b3.addActionListener(this);
        
        b4 = new JButton("Logout");  
        b4.setBounds(1000,510,85,25);  
        b4.addActionListener(this);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(l2);
		f.add(l3);
		f.add(l1);
		
		f.setSize(1124,633);
		f.setTitle("Home");
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(i2.getImage());
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
			new Update(u);
			f.setVisible(false);
		}
		
		if(e.getSource()==b4)
		{
			new Login(u);
			f.setVisible(false);
		}
	}
}
