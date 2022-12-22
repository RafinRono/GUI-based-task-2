package Classes;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Login implements ActionListener
{
	static User users[] = new User [100000];
	
	static User u;
	
	JFrame f;
	
	ImageIcon i1, i2;
	
	JLabel l1, l2, l3;
	
	JTextField tf;
	
	JPasswordField pf;
	
	JButton b1, b2, b3, b4;
	
	public Login(User a)
	{
		u = a;

		add(u);
		
		f= new JFrame(); 
        
        i1 = new ImageIcon("Images/pic.png");
        i2 = new ImageIcon("Images/pic1.png");
        
		l1 = new JLabel("Username:");
		l1.setFont(new Font("Comic Sans MS",Font.BOLD, 15));
		l1.setForeground( new Color (16, 235, 38) );
		l1.setBounds(245,420,100,30);

		l2 = new JLabel("Password:");
		l2.setFont(new Font("Comic Sans MS",Font.BOLD, 15));
		l2.setForeground( new Color (16, 235, 38) );
		l2.setBounds(247,446,100,30); 		
		
		l3 = new JLabel();
		l3.setIcon(i2);
		l3.setBounds(163,20,400,400);	
		
        tf = new JTextField();  
        tf.setBounds(326,426,160,23);  
		
		pf = new JPasswordField();  
        pf.setBounds(326,452,160,23); 
          
        b1 = new JButton("Login");  
        b1.setBounds(270,490,77,25);  
        b1.addActionListener(this);
        
        b2 = new JButton("Exit");  
        b2.setBounds(390,522,70,25);  
        b2.addActionListener(this);
        
        b3 = new JButton("Forgot Password?");
        b3.setBounds(360,490,137,25);
        b3.addActionListener(this);
       
        b4 = new JButton("Sign up");
        b4.setBounds(270,522,77,25);
        b4.addActionListener(this);
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
        f.add(tf);
        f.add(pf);
		f.add(b1); 
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
        f.setSize(750,650);  
        f.setLayout(null);  
        f.setTitle("Login");
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setIconImage( i1.getImage() );
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(43, 44, 48)); //another rgb code 64, 90, 227 255,137,0
        f.setVisible(true);             
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{  
			String user = tf.getText();
			String pass = String.valueOf(pf.getPassword());
			
			int counter = 0;
			
			for(int j=0; j<users.length; j++)
			{
				if(users[j]!=null)
				{
					if( user.equals(users[j].getUserName()))
					{
						if( pass.equals(users[j].getPassword()))
						{
							u = users[j];
							counter = 1;
							break;
						}
					}
				}
			}
			
			if(counter!=0)
			{
				//f.dispose();
				f.setVisible(false);
				new Home(u);
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid username and password");
			}
        }
		
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		
		if(e.getSource()==b3)
		{
			f.setVisible(false);
			new ForgotPass(u);
		}
		
		if(e.getSource()==b4)
		{
			f.setVisible(false);
			new Register(u);
		}
	}
	
	public static String forgetPass(String a)
	{
		String b = null;
		
		for(int i = 0; i<users.length; i++)
		{
			if(users[i]!=null)
			{
				if( a.equals(users[i].getUserName()))
				{
					b = users[i].getPassword();
					break;
				}
			}	
		}
		return b;
	}
	
	public static void addUser(User a)
	{
		int count = 0;
		
		for(int i = 0; i<users.length; i++)
		{
			if(users[i] == null)
			{
				users[i] = a;
				count++;
				break;
			}
		}
		
		if(count != 0)
		{
			JOptionPane.showMessageDialog(null, "User added successully.");
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry. User can not be added.");
		}
	}
	
	public static User searchUser(User a)
	{
		User test = null;
		
		for (int i=0;i<users.length;i++)
		{
			if(users[i]!=null)
			{
				if(a.getUserName().equals(users[i].getUserName()))
				{
					test = users[i];
					break;
				}
		   }
		}
		return test;
	}

	public static void add(User a)
	{
		for(int i = 0; i<users.length; i++)
		{
			if(users[i] == null)
			{
				users[i] = a;
				break;
			}
		}
	}
}
