package P108;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


// Note : every thing is private except the createFrame function to use it in the main 
// to apply the encapsulation 



public class UserClass implements ActionListener
{
	// the first frame 
	private static JFrame frame1;
	
	// text field to enter the user name 
	private static JTextField  username;
	
	// password field to enter the password
	private static JPasswordField password;
	
	// button to start checking the username and password and go on
	private static JButton login;
	
	public void createFram()
	{
		//fonts we use at labeles
		Font f1 = new Font("MV Boli",Font.BOLD,15);
		Font f22 = new Font("MV Boli",Font.BOLD,20);
		Font f2 = new Font("Arial",Font.BOLD,15);

		// image to use on the icone image
		ImageIcon imgicon = new ImageIcon ("C://Users//Momen..G.Ar//eclipse-workspace//finalProj//508970.png");
		
		
		// the propities of the first frame ( login frame )
		frame1 = new JFrame("Login");
		frame1.getContentPane().setBackground(new Color(224,244,244));
		frame1.setIconImage(imgicon.getImage());
		frame1.setSize(360,400);
		frame1.setResizable(false);
		frame1.setLayout(null);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.setLocation(600,300);
		
		
		// labels to tell user about input
		JLabel uu,pp,wel;
		
		wel = new JLabel("Login With Your Information"); // title
		wel.setFont(f22);
		wel.setBounds(20, 15,300,30);
		
		
		uu = new JLabel("Username");// label username input
		uu.setFont(f1);
		uu.setBounds(15, 70,100,30);
		
		
		pp = new JLabel("Password");// label password input
		pp.setFont(f1);
		pp.setBounds(15, 120,100,30);
		
		
		
		
		
		// text field to enter the username in it
		username = new JTextField();
		username.setFont(f2);
		username.setBounds(100, 70, 200, 30);
		username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// password field to enter the password
		password = new JPasswordField();
		password.setBounds(100, 120, 200, 30);
		password.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		// login buuton to start checking about the username and password
		login = new JButton("Login");
		login.setBounds(125, 220, 100, 40);
		login.setFont(new Font("Arial",Font.BOLD,15));
		
		// adding the componants to the frame
		frame1.add(login);
		frame1.add(username);
		frame1.add(password);
		frame1.add(uu);
		frame1.add(pp);
		frame1.add(wel);
		
		
		// add action listeners to the textField , passwordField  and button
		username.addActionListener(new UserClass());
		password.addActionListener(new UserClass());
		login.addActionListener(new UserClass());
		
		
		
		
		// set the frame visible as true
		frame1.setVisible(true);
		
	}
	
	
	// the strings to store the name and password that come from textField
	private String name,pass;
	
	// declerate an object from GPA class
	// The GPA class is start Just if the user name and password is correct
	private static GPA gpa;

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) // the action performed
	{
		
		
		if(e.getSource() == login)// the login buuton clicked
		{
			// take username and password from the fields
			name = username.getText();
			pass = password.getText();
			
			// check the username and password
			if(check(name,pass))
			{
				// true username and password => stars the GPA class and set frame1 non visible
				frame1.setVisible(false);
				gpa = new GPA();
				gpa.craetGPA(name);
				
			}else
			{
				// Joption pain : the user or password is wrong
		
				JOptionPane.showMessageDialog(null, "Wrong username or password, Try Again ",
														"Wrong", JOptionPane.ERROR_MESSAGE);
				username.setText("");
				password.setText("");
				
			}
			
		}
	}
	
	// boolean returened function to check if the username and password is true or not
	private boolean check(String n , String p)
	{
		// Checking ...
		if(n.equals("Momin")) // first user
		{
			return (p.equals("112233"));
		}
		else if(n.equals("Palestine")) // second user
		{
			return (p.equals("27027"));
		}
		else if(n.equals("Hazem")) // third user
		{
			return (p.equals("12345"));
		}
		else
		{
			return false;
		}
	}
	
	
	
}







