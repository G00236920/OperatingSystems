package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Registration {
	
	//Socket
	Socket requestSocket;
	
	//Output and input stream
	ObjectOutputStream out; 
	ObjectInputStream in;
	
	//Variables for message Passing
	String message;
	int intMessage;
	double doubleMessage;
	
	//Scanner
	Scanner stdin = new Scanner(System.in);

	//Constructor
	Registration(Socket requestSocket, ObjectOutputStream out, ObjectInputStream in) throws ClassNotFoundException, IOException {
		
		this.requestSocket = requestSocket;				//Socket
		this.in = in;									//incoming
		this.out = out;									//outgoing
		
		Start();
		
	}
	
	//Start the client
	void Start() throws ClassNotFoundException, IOException {
	
		//Ask for Name
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send Name to server
		message = stdin.nextLine();
		Requester.sendMessage(message);
		
		//Ask for Password
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send Password to server
		message = stdin.nextLine();
		Requester.sendMessage(message);
		
		//Ask for address
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send address to server
		message = stdin.nextLine();
		Requester.sendMessage(message);
		
		//Ask for Pps Number
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send pps Number to server
		message = stdin.nextLine();
		Requester.sendMessage(message);
		
		//Ask for age
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send age to server
		intMessage = stdin.nextInt();
		Requester.sendMessage(Integer.toString(intMessage));
		
		//Ask for weight
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send weight to server
		doubleMessage = stdin.nextDouble();
		Requester.sendMessage(Double.toString(doubleMessage));
		
		//Ask for Height
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send Height to server
		intMessage = stdin.nextInt();
		Requester.sendMessage(Integer.toString(intMessage));
		
	}
	
}
