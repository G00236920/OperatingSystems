package ie.gmit.os;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.*;


public class Runner {
	
//Tab Titles
 	final static String FCFSText = "FCFS";
    final static String SJFText = "SJF";
    final static String ROUNDROBINText = "Round Robin";
   
//Textfield Values    
    private static int noProcess = 5; 
    private static int quantum = 3;
    
//Tab Panels    
    private static JPanel processPanel1 = new JPanel();
    private static JPanel processPanel2 = new JPanel();
    private static JPanel processPanel3 = new JPanel();
 
//Textfields for No of Processes    
    private static JTextField noProcessText1;
    private static JTextField noProcessText2;
    private static JTextField noProcessText3;
 
//Linked list to store Processes    
    private static LinkedList<Process> process = new LinkedList<Process>();

//Linked list of JTextfields for user input    
    private static LinkedList<JTextField> timeFCFS = new LinkedList<JTextField>();
    private static LinkedList<JTextField> timeSJF = new LinkedList<JTextField>();
    private static LinkedList<JTextField> timeRR = new LinkedList<JTextField>();
    private static JTextField quantumField = new JTextField(Integer.toString(quantum),5);
	    

	    public static void main(String[] args) {
	        
	    		//Create GUI
	    		createAndShowGUI();
	    	
	    }
	    
	    private static void createAndShowGUI() {
	        
	    		//Jframe
	        JFrame frame = new JFrame("Process Control");
	        //Occurance if frame closed
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Create and set up the content pane.
	        Runner menu = new Runner();
	        //Add each component to the Jframe
	        menu.addComponentToPane(frame.getContentPane(), frame);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	        
	    }
	 
	    public void addComponentToPane(Container pane, JFrame frame) {
	    	
	    //Panel Sizes 
	    	processPanel1.setPreferredSize(new Dimension(300, 30*getNoProcess()));
	    	processPanel2.setPreferredSize(new Dimension(300, 30*getNoProcess()));
	    	processPanel3.setPreferredSize(new Dimension(300, 30*getNoProcess()));
	    	
	    	//Fields to store user input
	    noProcessText1 =	new JTextField(Integer.toString(getNoProcess()), 5);
	    noProcessText2 =	new JTextField(Integer.toString(getNoProcess()), 5);
	    noProcessText3 =	new JTextField(Integer.toString(getNoProcess()), 5);
	    	
//Card 1 Setup		
	    		JButton button1 = new JButton("Start");			//Start Button
	        JPanel card1 = new JPanel();
	        JPanel panel1 = new JPanel();
	        panel1.setSize(new Dimension(300, 5));
	        JPanel panel2 = new JPanel();
	        panel2.setSize(new Dimension(300, 5));
	        JPanel panel3 = new JPanel();
	        panel3.setSize(new Dimension(300, 5));
	       //3 panels placed inside a card panel, one for process numbers, one for process times, one for buttons 
	        
	        card1.add(panel1);
	        card1.add(panel2);
	        card1.add(processPanel1);
	        card1.add(panel3);
	        //Panels added to card
	        
	        panel1.add(new JLabel("No. of Processes (#)"));
	        panel1.add(noProcessText1);
	        panel3.add(button1);
	        panel3.add(new JButton("Exit"));
	        card1.setPreferredSize(new Dimension(300, 30*getNoProcess() +250));
	        card1.setLayout(new BoxLayout(card1, BoxLayout.PAGE_AXIS));			//Card Layout
	        //Components added to cards
	 
//Card 2 Setup
	        JButton button2 = new JButton("Start");
	        JPanel card2 = new JPanel();
	        JPanel panel4 = new JPanel();
	        JPanel panel5 = new JPanel();
	        JPanel panel6 = new JPanel();
		    //3 panels placed inside a card panel, one for process numbers, one for process times, one for buttons 
	       
	        card2.add(panel4);
	        card2.add(panel5);
	        card2.add(processPanel2);
	        card2.add(panel6);
	        //Panels added to card
	        
	        panel4.add(new JLabel("No. of Processes (#)"));
	        panel4.add(noProcessText2);
	        panel6.add(button2);
	        panel6.add(new JButton("Exit"));
	        card2.setPreferredSize(new Dimension(300, 20*getNoProcess() +200));
	        card2.setLayout(new BoxLayout(card2, BoxLayout.PAGE_AXIS));				//card layout 
	        //Components added to cards
	        
//Card 3 Setup	 
	        JButton button3 = new JButton("Start");
	        JPanel card3 = new JPanel();
	        JPanel panel7 = new JPanel();
	        JPanel panel8 = new JPanel();
	        JPanel panel9 = new JPanel();
		    //3 panels placed inside a card panel, one for process numbers, one for process times, one for buttons 
	        
	        card3.add(panel7);
	        card3.add(panel8);
	        card3.add(processPanel3);
	        card3.add(panel9);
	        //Panels added to card
	        
	        panel7.add(new JLabel("No. of Processes (#)"));
	        panel7.add(noProcessText3);
	        panel8.add(new JLabel("Quantum (s)"));
	        panel8.add(quantumField);
	        panel9.add(button3);
	        panel9.add(new JButton("Exit"));
	        card3.setPreferredSize(new Dimension(300, 20*getNoProcess() +200));
	        card3.setLayout(new BoxLayout(card3, BoxLayout.PAGE_AXIS));
	        //Components added to cards
	        
	        createProcessPanels();
	     
	        
//FCFS Button
	        button1.addActionListener(new ActionListener(){
	        	
                public void actionPerformed(ActionEvent e){			//Listen for button activation
                	
        	    	
                    while (!getProcess().isEmpty()) {					//Empty the Current List
                        getProcess().removeFirst();					//Keeps removing first item in the list until the list is empty
                    }
                	
	                	for(int i = 0; i < getNoProcess(); i++) {		//Loop Through each textfield and Gather the inputs
	                		
	                		JTextField text = timeFCFS.get(i);			//Store the inputs in temp variable 	
	                		
		                	Process p = new Process( (i+1) , Integer.parseInt(text.getText()));	
		                	//Create a new process
		                	//Pass in the i as an int, which becomes the name of the process
		                	//Convert that variable to a string then an Int, this becomes the time the process will run for
		                	
		                	getProcess().add(p);		//Add the process to a linked list
		                		
	                	}
	                	
	                	String output = FCFS.output(process);	
	                	//each class called will have an output generated 
	                	//This will then be shown in a JOptionPane
	                	
	                	JOptionPane.showMessageDialog(null, output);
	                	//Show the output message
                	
                }
            });
	        
	        
//SJF Button	        
	        button2.addActionListener(new ActionListener(){
	        	
                public void actionPerformed(ActionEvent e){			//Listen for button activation
                	
        	    	
                    while (!getProcess().isEmpty()) {					//Empty the Current List
                        getProcess().removeFirst();					//Keeps removing first item in the list until the list is empty
                    }
                	
	                	for(int i = 0; i < getNoProcess(); i++) {		//Loop Through each textfield and Gather the inputs
	                		
	                		JTextField text = timeSJF.get(i);			//Store the inputs in temp variable 	
	                		
		                	Process p = new Process( (i+1) , Integer.parseInt(text.getText()));
		                	//Create a new process
		                	//Pass in the i as an int, which becomes the name of the process
		                	//Convert that variable to a string then an Int, this becomes the time the process will run for
		                	
		                	getProcess().add(p);		//Add the process to a linked list
		                		
	                	}
	                	
	                	
	                	//Compare and Sort the Collection to order by the process with the smallest runtime 
	                	Collections.sort(process, new Comparator<Process>() {
	                	    @Override
	                	    
	                	    public int compare(Process o2, Process o1) {
	                	    		
	                	        return o2.getProcessTime() - o1.getProcessTime();
	                	        
	                	    }
	                	    
	                	});
	                	
	                	String output = SJF.output(process);		//Gather the outputs
	                	
	                	JOptionPane.showMessageDialog(null, output);	//Output Result
                	
                }
            });
	        
	        
//Round Robin Button	        
	        button3.addActionListener(new ActionListener(){
	        	
                public void actionPerformed(ActionEvent e){
                	
                		quantum = Integer.parseInt(quantumField.getText());
                		
        	    	
                    while (!getProcess().isEmpty()) {					//Empty the Current List
                        getProcess().removeFirst();					//Keeps removing first item in the list until the list is empty
                    }
                	
	                	for(int i = 0; i < getNoProcess(); i++) {
	                		
	                		JTextField text = timeRR.get(i);				//Gather the number of processes
	                		
		                	Process p = new Process( (i+1) , Integer.parseInt(text.getText()));	
		                	// use i+1 as No/Name of process
		                	//Convert this to string then int, use as process run time
		                	
		                	
		                	getProcess().add(p);
		                	//Add new process to linked list
		                		
	                	}
	                	
	                	String output = RoundRobin.output(process, quantum);
	                	//Gather output info
	                	
	                	JOptionPane.showMessageDialog(null, output);
	                	//Output Result
                	
                }
            });
	      
	        
//Listen to TextField 1	        
	        noProcessText1.addActionListener(new ActionListener(){
	        	
                public void actionPerformed(ActionEvent e){				//Listen for change in number of Processes
                	
	                	pane.setVisible(false);									//Hide last window
	                	setNoProcess(Integer.parseInt(noProcessText1.getText()));	//Convert no of process field to int
	                	
	                	frame.dispose();											//Dispose of old frame
	                	createAndShowGUI();										//Generate new frame with new process number

                }
            });
	        
	        
//Listen to TextField 2	        
	        noProcessText2.addActionListener(new ActionListener(){		//Listen for change in number of Processes
	        	
                public void actionPerformed(ActionEvent e){
                	
	                	pane.setVisible(false);								//Hide last window
	                	setNoProcess(Integer.parseInt(noProcessText2.getText()));//Convert no of process field to int
	                	
	                	frame.dispose();											//Dispose of old frame
	                	createAndShowGUI();										//Generate new frame with new process number

                }
            });

	        
//Listen to TextField 3
	        noProcessText3.addActionListener(new ActionListener(){			//Listen for change in number of Processes
	        	
                public void actionPerformed(ActionEvent e){

	                	pane.setVisible(false);									//Hide last window
	                	setNoProcess(Integer.parseInt(noProcessText3.getText()));//Convert no of process field to int
	                	
	                	frame.dispose();											//Dispose of old frame
	                	createAndShowGUI();										//Generate new frame with new process number

                }
            });
	        
	        
//Add Cards to Frame	    
	        JTabbedPane tabbedPane = new JTabbedPane();
	        tabbedPane.addTab(FCFSText, card1);
	        tabbedPane.addTab(SJFText, card2);
	        tabbedPane.addTab(ROUNDROBINText, card3);
	 
	        pane.add(tabbedPane, BorderLayout.CENTER);
	    }
	    
	    public static void createProcessPanels() {
	    	
        while (!getProcess().isEmpty()) {			//Empty the Current List
            getProcess().removeFirst();				//Keeps removing first item in the list until the list is empty
            timeFCFS.removeFirst();					//Keeps removing first item in the list until the list is empty
            timeSJF.removeFirst();					//Keeps removing first item in the list until the list is empty
            timeRR.removeFirst();					//Keeps removing first item in the list until the list is empty
        }
	    	
	    	processPanel1.removeAll();
	    	processPanel2.removeAll();
	    	processPanel3.removeAll();
	    	
	        for(int i = 0; i< getNoProcess(); i++) {
	        	
	        	//Fill Jtextfields so they are not blank at first
	        		JTextField j1 = new JTextField("10", 15);
	        		JTextField j2 = new JTextField("10", 15);
	        		JTextField j3 = new JTextField("10", 15);
	        		
	        		//Add int values from textfields to lists
	        		timeFCFS.add(j1);
	        		timeSJF.add(j2);
	        		timeRR.add(j3);
	        		
	        		//Add process panels with the number for each process
	        		processPanel1.add(new JLabel("Process "+(i+1)));
	        		processPanel1.add(j1);
	        		processPanel2.add(new JLabel("Process "+(i+1)));
	        		processPanel2.add(j2);
	        		processPanel3.add(new JLabel("Process "+(i+1)));
	        		processPanel3.add(j3);
        		
	        }	 
	    }

	    //Setters and Getters
		public static int getNoProcess() {
			return noProcess;
		}

		public static void setNoProcess(int noProcess) {
			Runner.noProcess = noProcess;
		}

		public static LinkedList<Process> getProcess() {
			return process;
		}

		public static void setProcess(LinkedList<Process> process) {
			Runner.process = process;
		}
	    
	}
