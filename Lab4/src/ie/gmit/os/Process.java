package ie.gmit.os;

public class Process {
	
	//Private Variables
	private int processNo;
	private int processTime;
	private int remainingTime;
	private int startTime;
	private int waitTime;
	private int runCount;
	
	Process(int no, int time){
		this.processNo = no;						//Process Name
		this.processTime = time;					//Process Run Time
		this.remainingTime = time;				//Remaining time before process finishes
		this.startTime = 0;						//When the Process starts to run, each time it runs
		this.waitTime = 0;						//Wait time, Determined by the time the last part of the process runs, 
												//*(how many times it runs * the Qunatum)
		this.runCount = 0;						//Run count, Not counting the final time it runs
	}
	

	//Setters and Getters
	public int getStartTime() {
		return startTime;
	}


	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}


	public int getWaitTime() {
		return waitTime;
	}


	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}


	public int getRunCount() {
		return runCount;
	}


	public void setRunCount(int runCount) {
		this.runCount += runCount;
	}


	public int getProcessNo() {
		return processNo;
	}

	public void setProcessNo(int processNo) {
		this.processNo = processNo;
	}

	public int getProcessTime() {
		return processTime;
	}

	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime -= remainingTime;
	}
	
	public String toString() {

		//Return the outputs here
		return String.format("%15d %20d %26d %25d\n", this.processNo, this.startTime, this.remainingTime, this.waitTime);
	}
	

}
