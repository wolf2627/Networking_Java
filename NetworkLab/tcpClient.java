import java.io.*;
import java.net.*;
import java.util.*;


public class tcpClient{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the host address: ");
            	String host_addr = sc.nextLine();
		System.out.print("Enter the port to connect : ");
		int port = sc.nextInt();
		try{
			Socket s = new Socket(host_addr, port);
			BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			String usermessage, servermessage;
			System.out.println("Connected with Server");
			System.out.println("Type /'bye/' to Disconnect from Server");
			while(true){
				System.out.print("Enter the Message to Server: ");
				usermessage = userinput.readLine();
				if(usermessage.equals("bye")){
					out.println("bye");
					break;
				} else {
					out.println(usermessage);
					servermessage = in.readLine();
					System.out.println("Server : "+ servermessage);
				}
				
			}
			System.out.println("Disconneceted From Server");
		} catch(IOException e){
			System.err.println("Error Occured : "+e.getMessage());
		} 
	}
}
