package ie.gmit.os;

import java.util.LinkedList;

public class SJF {
	
	public static String output(LinkedList<Process> process){

		int startTime = 0;
		
		//Header
		String text  = String.format("%-20s %-20s %-20s %-20s\n", "Process Name", "Start Time", "Run Time","Wait Time");
		
	    	for(int i = 0; i < Runner.getNoProcess(); i++) {
	   
	    		//Set start time based on current time
	    		process.get(i).setStartTime(startTime);
	    		//Set wait time based on current time
	    		process.get(i).setWaitTime(startTime);
	    		//No remaining time as jobs run completely, in order of smallest first
	    		startTime += process.get(i).getRemainingTime();
	    		//Output 
	    		text  += process.get(i).toString();

	    	}
	    	//Average wait time
	    	double average = startTime/Runner.getNoProcess();
	    	//text output for Average time
	    	text += "\n\nAverage Wait Time is: " +average; 
		
	    	//Return the string output so user can see
		return text;
		
	}
	
}
