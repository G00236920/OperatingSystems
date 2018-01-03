package Client;


import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Requester{
	
	
	Socket requestSocket;				//Socket 
	static ObjectOutputStream out;		//Outgoing
 	ObjectInputStream in;				//Incoming
 	String message="";					//Message being Sent
 	String ipaddress;					//The IP of server
 	Scanner stdin;						//Scanner
 	
 	
 	//Main Method, First Method to run, Creates the Requester Object and Runs the Client
	public static void main(String args[])
	{
		Requester client = new Requester();
		client.run();
	}
	
	
 	Requester() {				//Constructor Blank
		
	}
 	
 	
	void run(){ 				//Requester Run Method
		
		//Scanner
		stdin = new Scanner(System.in);
		
		try{
			
			//Ask User for IP address
			System.out.println("Please Enter your IP Address");
			ipaddress = stdin.next();														//Uncomment Later
			
			//ipaddress = "35.197.218.138";													//Hard coded IP for testing - Comment Out Later
			
			//Make Request to Connect to Server
			requestSocket = new Socket(ipaddress, 2004);
			System.out.println("Connected to "+ipaddress+" in port 2004");
			
			//Output Stream
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			
			//Input Stream
			in = new ObjectInputStream(requestSocket.getInputStream());
			
			
			//3: Communicating with the server
			do{
				try
				{
					//Get the message that will be shown to screen from the server
					message = (String)in.readObject();
					
					//Print the Message to screen
					System.out.println(message);
					
					//Get Input from the user
					message = stdin.next();
					
					//Send the users input to the server
					sendMessage(message);
					
					switch(message){			//Determine what happens with the users input 1,2,3 anything else is invalid
					
						case "1":
							
							//When the User is Registering for a new Account 
							message = (String)in.readObject();
							System.out.println(message);
							
							//Register a new User
							new Registration(requestSocket, out, in);		
							
							break;
							
						case "2":
							
							//When the User is Logging in
							message = (String)in.readObject();
							System.out.println(message);
							
							//Attempt Login
							new Login(requestSocket, out, in);
							
							break;
							
						case "3":
							System.out.println("GoodBye");
							//Exit the Program
							
							break;
							
							default:
								System.out.println("Incorrect value");
					}	
						
				}
				catch(ClassNotFoundException classNot)
				{
					//Catch Incorrect format
					System.err.println("data received in unknown format");
				}
				
				
			}while(!message.equals("3"));			//3 Quits the Program
			
		}
		catch(UnknownHostException unknownHost){
			
			//Host not found
			System.err.println("You are trying to connect to an unknown host!");
			
			
		}
		catch(IOException ioException){
			
			ioException.printStackTrace();
			
		}
		finally{
			//Close the Connections When Done
			try{
				
				in.close();				//Close Input
				out.close();			//Close Output
				requestSocket.close();	//Close Connection to server
				
			}
			catch(IOException ioException){
				
				ioException.printStackTrace();
				
			}
		}
	}
	
	static void sendMessage(String msg) { 				//Send a Message back to the server
		
		try{
			
			//Write the message to the server
			out.writeObject(msg);
			out.flush();
			
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		
	}
	
}