package ie.gmit.os;

import java.util.LinkedList;

public class RoundRobin {

	public static String output(LinkedList<Process> process, int quantum) {
		
		int time = 0;				//Run time incremented by process values
		
		//Header
		String text  = String.format("%-20s %-20s %-20s %-20s\n", "Process Name", "Start Time", "Remaining Time","Wait Time");
		int finished = 0;			//How many Jobs have finished
		
		while(finished < process.size()) {	//Run until all jobs are finished at the same time
			
			for(int i = 0; i<process.size(); i++) {		//Loop through the processes from first to last
				
				process.get(i).setStartTime(time);		//Set start time when process runs again
				process.get(i).setWaitTime(time - (quantum * process.get(i).getRunCount()));
				//Set how long the process waited
			
				if( process.get(i).getRemainingTime() > 0  && process.get(i).getRemainingTime() > quantum) {
					//If this isnt the final time the process will run
					
					time += quantum;	
					//Add the quantum to current time
					
					process.get(i).setRemainingTime(quantum);
					//Set how much time the process has left before complete
					
					process.get(i).setRunCount(1);
					//Increment the process run count
					
					text  += process.get(i).toString();
					//Add output for the process to the final output string
				
					finished = 0;
					//this is not the final run for this process so reset the finished counter
				}
				else 
				{
					//Final run for this process
					
					time += process.get(i).getRemainingTime();
					//Increment the timer by how much time the process has instead of quantum
					//Quantum will either be larger or equal to time remaining
					
					process.get(i).setRemainingTime(process.get(i).getRemainingTime());
					//set the remaining time to 0 by subtracting remaining time by itself
					
					text  += process.get(i).toString();
					//Output text - add current process details to final output
					
					finished++;
					//Increment the finished counter by one as this process is complete
					
				}
				
			}

			
		}
	    	
		//Output final Round Robin text
	    	text += "\n\nAverage Wait Time is: "+(time/process.size()); 
		
	    	//Return the string so it can be seen by user
		return text;
	}

}
