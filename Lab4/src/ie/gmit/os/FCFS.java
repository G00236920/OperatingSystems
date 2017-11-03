package ie.gmit.os;

import java.util.LinkedList;

public class FCFS {
	
	public static String output(LinkedList<Process> process){

		int startTime = 0;			
		
		//Header
		String text  = String.format("%-20s %-20s %-20s %-20s\n", "Process Name", "Start Time", "Run Time","Wait Time");
		
	    	for(int i = 0; i < Runner.getNoProcess(); i++) {
	    		
	    		//Set the start time by current run time
	    		process.get(i).setStartTime(startTime);
	    		//Set wait time by the current time
	    		process.get(i).setWaitTime(startTime);
	    		//Remaining time will be 0 as the whole process runs
	    		startTime += process.get(i).getRemainingTime();
	    		//Gather outpt for the JoptionPane
	    		text  += process.get(i).toString();

	    	}
	    	//Average
	    	double average = startTime/Runner.getNoProcess();
	    	//Text for average calculation
	    	text += "\n\nAverage Wait Time is: " +average; 
		
	    	
	    	//Return the String value so it can be shown to user
		return text;
		
	}

}
