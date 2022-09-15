package P108;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class GPA implements ActionListener
{
	// fonts to user in texts
	Font f1 = new Font("MV Boli",Font.BOLD,20);
	Font f2 = new Font("Arial",Font.BOLD,20);
	
	// lables 
	private static JLabel username,gpa;
	
	// the Frame
	private static JFrame welcome;
	
	// Button to start calculate the GPA
	private static JButton start;
	
	public void craetGPA (String name)
	{
		
		
		
		// image icons
		ImageIcon imgicon = new ImageIcon 
				("C://Users//Momen..G.Ar//eclipse-workspace//finalProj//508970.png"); // icon image of frame
		ImageIcon uni = new ImageIcon 
				("C://Users//Momen..G.Ar//eclipse-workspace//Final Project//src//download.jpg");// image in picture
		
		// properties of the label and picture
		JLabel img = new JLabel(uni); 
		img.setBounds(50,100,200,135);
		img.setHorizontalAlignment(JLabel.CENTER);
		
		
		// the properties of the welcome frame
		welcome = new JFrame ("Welcome");
		welcome.setLayout(null);
		welcome.setSize(310, 400);
		welcome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		welcome.getContentPane().setBackground(new Color(214, 214, 214));
		welcome.setIconImage(imgicon.getImage());
		welcome.setResizable(false);
		welcome.setLocation(600,300);
		
		
		
		// the properties of username label 
		username = new JLabel("Welcome " + name);
		username.setFont(f1);
		username.setBounds(50,20,200,50);
		username.setHorizontalAlignment(JLabel.CENTER);
		username.setOpaque(true);
		username.setBackground(new Color(214, 214, 214));
		username.setForeground(new Color(254, 163, 98));
		
		
		// The properties of GPA label
		gpa = new JLabel("Caculate GPA");
		gpa.setFont(f1);
		gpa.setBounds(50,80,200,50);
		gpa.setHorizontalAlignment(JLabel.CENTER);
		gpa.setOpaque(true);
		gpa.setBackground(new Color(214, 214, 214));
		gpa.setForeground(new Color(254, 163, 98));
		
		
		// the properties of the Start button
		start = new JButton("Start");
		start.setBounds(100,250,100,50);
		start.addActionListener(new GPA()); // action listener
		
		
		
		// add the components to the frame
		welcome.add(username);
		welcome.add(gpa);
		welcome.add(start);
		welcome.add(img);
		
		
		// set the frame visible (true)
		welcome.setVisible(true);
	}
	
	
	
	
	
	// to store the number if subjects
	private static int numberOfSubjects = 0;
	private static String numberOfSubjectsString ;
	
	
	@Override
	public void actionPerformed(ActionEvent e) // action performed 
	{
		// the event of click ( start button )
		if(e.getSource() == start)
		{
			// get the number of subjects from the text field
			numberOfSubjectsString = JOptionPane.showInputDialog(null,"Enter the number of subjects");
			numberOfSubjects =  Integer.parseInt(numberOfSubjectsString);
			
			// call a function to calculate the GPA
			Calculate(numberOfSubjects);
		}
		
	}
	
	
	
	
	
	
	// function to calculate the GPA
	private void Calculate(int x) // x : is the number of subjects 
	{
		// To store the hours and sum of Grades
		int hours = 0;
		Double SGrade = 0.0;
		
		
		// loop to enter the information
		for (int i = 0; i < x ;i++)
		{
		
			// Text fields to enter the Grade and its Hours
			JTextField PGrade = new JTextField();
			JTextField PHour = new JTextField();
			
			// Panel to Arrange the components in the JoptionPane 
			JPanel myPanel = new JPanel(new GridLayout(2,2,15,5));
			myPanel.add(new JLabel("The Grade" + (i + 1)));
			myPanel.add(PGrade);
			myPanel.add(new JLabel("The Hours"));
			myPanel.add(PHour);

			
			// to store input the data
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter the information", 
															JOptionPane.OK_CANCEL_OPTION);
			
			// check Action of click OK
			if (result == JOptionPane.OK_OPTION) 
			{
				// calculate the mark of each grade 
				double grade = Double.parseDouble(PGrade.getText()) * 1.0 *  Integer.parseInt(PHour.getText());
				SGrade += grade;
				hours += Integer.parseInt(PHour.getText());
			}
			else if(result == JOptionPane.CANCEL_OPTION) // if the user close without enter any thing
			{
				gpa.setText("The GPA = 0.0");
				break;
			}
			
		}
		
		// store the answer 
		Double ans = SGrade / hours;
		
		// set precision to 2 (2 floating points)
		ans = Double.parseDouble(String.format("%.2f", ans));
		
		// Change font and color of the font of labels
		username.setFont(f1);
		username.setForeground(Color.red);
		gpa.setForeground(Color.red);
		
		// rank statements
		if(ans >= 60)
		{
			username.setText("Congratulations");
			
		}else {
			
			username.setText("Try More Hard");
		}
		
		// print the GPA in the GPA lable
		gpa.setText("The GPA = "+ ans );
	}



	
	
	// Thank you 
	
	
	
}
