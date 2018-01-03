package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Login {
	
	Socket requestSocket; 
	ObjectOutputStream out; 
	ObjectInputStream in;
	String message;
	Scanner stdin2 = new Scanner(System.in);
	
	Login(Socket requestSocket, ObjectOutputStream out, ObjectInputStream in) throws ClassNotFoundException, IOException{
		
		//Ask for Name
		message = (String)in.readObject();

		System.out.println(message);
		
		//Send Name to server
		message = stdin2.nextLine();
		
		Requester.sendMessage(message);
		
		//Ask for Password
		message = (String)in.readObject();
		System.out.println(message);
		
		//Send Password to server
		message = stdin2.nextLine();
		Requester.sendMessage(message);
		
		//Login Status
		message = (String)in.readObject();
		System.out.println(message);
		
		if(message.equals((String)"Login Sucessful\n")) {
			do {
				//Logged in Menu
				message = (String)in.readObject();
				System.out.println(message);
				
				//Logged in menu selection
				message = stdin2.nextLine();
				Requester.sendMessage(message);
				
				switch(message){
					case "1":
						
					//Ask for Mode	
					message = (String)in.readObject();
					System.out.println(message);
					
					//Send mode to server
					message = stdin2.nextLine();
					Requester.sendMessage(message);
					
					//ask for duration
					message = (String)in.readObject();
					System.out.println(message);
					
					//Send Duration to server
					message = stdin2.nextLine();
					Requester.sendMessage(message);
					
						break;
					case "2":
						//Ask for type	
						message = (String)in.readObject();
						System.out.println(message);
						
						//Send type to server
						message = stdin2.nextLine();
						Requester.sendMessage(message);
						
						//ask for Description
						message = (String)in.readObject();
						System.out.println(message);
						
						//Send Description to server
						message = stdin2.nextLine();
						Requester.sendMessage(message);
						
						break;
					case "3":
						message = (String)in.readObject();
						
						for(int i = (Integer.parseInt(message)); i > 0; i--) {
							
							//Print the Fitness records at each index
							message = (String)in.readObject();
							System.out.println(message);
							
						}
						
						System.out.println("");
						
						break;
					case "4":
						message = (String)in.readObject();
						
						for(int i = (Integer.parseInt(message)); i > 0; i--) {
							
							//Print the Fitness records at each index
							message = (String)in.readObject();
							System.out.println(message);
							
						}
						
						System.out.println("");
						break;
					case "5":
						
						//Ask the User which Entry they wish to delete
						message = (String)in.readObject();
						System.out.println(message);
						
						//Send the index to the server
						message = stdin2.nextLine();
						Requester.sendMessage(message);
						
						break;
					case "6":
						
						//Ask the User which Entry they wish to delete
						message = (String)in.readObject();
						System.out.println(message);
						
						//Send the index to the server
						message = stdin2.nextLine();
						Requester.sendMessage(message);
						
						break;
					case "7":
						return;
	
						default:
							System.out.println("Invalid Selection");
				}
				
			
			}while(!message.equals("7"));
		}
		
	}

}
