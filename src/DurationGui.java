import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class DurationGui extends JFrame implements ActionListener
{
	//text field for results
	//private JTextField results;
	
	//text area
	private JTextArea taResults;
	
	//button to close the form
	private JButton btnOk; 
	private JButton btnCreateReport;
	
	//file for report
	private PrintWriter durationReport;
	
	
	
	public DurationGui()  
	{
		super ("Profiler Results");
		
		setSize(new Dimension(800,600)); //size of form
		//setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		Duration test = new Duration();
	
		taResults = new JTextArea(20,10);
		
		//file to create
		try
		{
			durationReport = new PrintWriter("C:\\DurationReport.txt");
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Title
		taResults.append("Duration Report \n" + "-----------------------------------------");

			//create buttons
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		
		btnCreateReport = new JButton("Save Report");
		btnCreateReport.addActionListener(this);
		btnCreateReport.setToolTipText("File is created on root");
		
		
		//jframes
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1,2));
		south.add(btnOk);
		south.add(btnCreateReport);
		
		//build form
		getContentPane().add(new JScrollPane(taResults), BorderLayout.CENTER);
		getContentPane().add(south, BorderLayout.SOUTH);
		
		
		//auto size buttons and screen;
		pack();
		
		//*************************
		//default Close Operation set to exit on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		
		//*************************
		//show Content Pane
		setVisible(true);
		
	}
	
	
	 //events for buttons  pixels and text boxes
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == btnOk)
			{
				dispose();
			}
			
			if (e.getSource() == btnCreateReport)
			{
				
				createReport();
				
			}
		}	
		

	
		//***********************************************************************
		//METHODS
		
		//method to append text to field
		public void updateTextBox(String n, String v)
		{
			
			taResults.append("\n" +"*********************************" + "\n" + n + ": " + v.replace("|", "\n").replace("[", " ").replace("]", "\n").replace(",", "\n")+"*********************************");
			
			
			
		}
		
		//method to make the file
		private void createReport()
		{
			durationReport.println(taResults.getText());
			durationReport.close();
			
		}

		
		
		
		
		
}
