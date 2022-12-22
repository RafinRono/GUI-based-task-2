package Classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Update implements ActionListener
{
	static User u;
	
	JFrame f;
	
	ImageIcon i1,i2;
	
	JLabel l1,l2,l3,l4,l5,l6;
	
	JButton b1, b2, b3, b4, b5;
	
	JTextField tf1;
	
	JRadioButton r1, r2, r3;
	
	ButtonGroup bg1;
	
	JCheckBox c1, c2, c3, c4;
	
	JComboBox<?> combo;
	
	Update(User a)
	{
		u = a;
		
		f = new JFrame();
		
		i1 = new ImageIcon ("Images/oko1.jpg");
		i2 = new ImageIcon ("Images/oko2.jpg");
		
		l1 = new JLabel();
		l1.setIcon(i1);
		l1.setBounds(0,0,1124,633);
		
		l2 = new JLabel("Info:");
		l2.setBounds(540,150,270,30);
		l2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		l2.setForeground(new Color (255,254,237));
		
		l3 = new JLabel("Gender: ");
		l3.setBounds(420,200,350,30);
		l3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l3.setForeground(new Color (255,254,237));
		
		l4 = new JLabel("Contact Number: ");
		l4.setBounds(405,240,350,30);
		l4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l4.setForeground(new Color (255,254,237));
		
		l5 = new JLabel("Major: ");
		l5.setBounds(460,280,350,30);
		l5.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l5.setForeground(new Color (255,254,237));
		
		l6 = new JLabel("Certificates: ");
		l6.setBounds(410,320,350,30);
		l6.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		l6.setForeground(new Color (255,254,237));
		
		tf1 = new JTextField();
		tf1.setBounds(580,246,100,25);
		
		b1 = new JButton("Pervious");  
        b1.setBounds(17,15,85,25);  
        b1.addActionListener(this);
        
        b2 = new JButton("Exit");  
        b2.setBounds(1000,15,85,25);  
        b2.addActionListener(this);
        
        b3 = new JButton("Update");  
        b3.setBounds(533,515,85,25);  
        b3.addActionListener(this);
        
        b4 = new JButton("Logout");  
        b4.setBounds(1000,515,85,25);  
        b4.addActionListener(this);
        
        b5 = new JButton("Next");  
        b5.setBounds(533,547,85,25);  
        b5.addActionListener(this);

        r1 = new JRadioButton("Male");
        r1.setBounds(510,207,60,20);
        r1.setFont(new Font("Default",Font.BOLD,14));
        
        r2 = new JRadioButton("Female");
        r2.setBounds(580,207,80,20);
        r2.setFont(new Font("Default",Font.BOLD,14));
        
        r3 = new JRadioButton("Others");
        r3.setBounds(670,207,80,20);
        r3.setFont(new Font("Default",Font.BOLD,14));
        
        bg1 = new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		bg1.add(r3);
		
		String items[] = {"CSE", "CS", "SE"};
		combo = new JComboBox<>(items);
		combo.setBounds(540, 282, 100, 30);
		
		c1 = new JCheckBox("SSC");
		c1.setBounds(550, 328, 50, 20);
		
		c2 = new JCheckBox("HSC");
		c2.setBounds(550, 358, 51, 20);
		
		c3 = new JCheckBox("Under-graduate");
		c3.setBounds(550, 388, 117, 20);
		
		c4 = new JCheckBox("Post-graduate");
		c4.setBounds(550, 418, 107, 20);
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(r1);
		f.add(r2);
		f.add(r3);
		f.add(tf1);
		f.add(combo);
		f.add(c1);
		f.add(c2);
		f.add(c3);
		f.add(c4);
		f.add(l1);
		
		f.setSize(1124,633);
		f.setTitle("Updating info");
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
			new Home(u);
			f.setVisible(false);
		}
		
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		
		if(e.getSource()==b3)
		{
			String a = null;
			
			if(r1.isSelected()==true) {a = r1.getText();}
			if(r2.isSelected()==true) {a = r2.getText();}
			if(r3.isSelected()==true) {a = r3.getText();}
			
			u.setGender(a);
			
			String b = tf1.getText();
			u.setContactNum(b);
			
			String c = combo.getSelectedItem().toString();
			u.setMajor(c);
			
			String d = null;
			String f1 = null;
			String g = null;
			String h = null;
			
			if(c1.isSelected()==true) {d = c1.getText();}
			if(c2.isSelected()==true) {f1 = c2.getText();}
			if(c3.isSelected()==true) {g = c3.getText();}
			if(c4.isSelected()==true) {h = c4.getText();}
			
			if(d!=null) {u.degrees.add(d);}
			if(f1!=null) {u.degrees.add(f1);}
			if(g!=null) {u.degrees.add(g);}
			if(h!=null) {u.degrees.add(h);}
			
			JOptionPane.showMessageDialog(null, "Info updated successfully");
			new Final(u);
			f.setVisible(false);
		}

		if(e.getSource()==b4)
		{
			new Login(u);
			f.setVisible(false);
		}

		if(e.getSource()==b5)
		{
			new Final(u);
			f.setVisible(false);
		}
	}
}
