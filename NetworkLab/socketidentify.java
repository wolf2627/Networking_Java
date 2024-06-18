import java.util.*;
import java.net.*;

class socketidentify{
	public static void main(String[] args) throws UnknownHostException {
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the address: ");
			String address = sc.nextLine();
			int port = 80;
			Socket s = new Socket(address, port);
			System.out.println("Connection to : "+s.getInetAddress());
			System.out.println("Port Number: "+s.getPort());
			System.out.println("Local Address: "+s.getLocalAddress());
			System.out.println("Local Port: "+s.getLocalPort());
		} catch(UnknownHostException e){
			System.err.println("Address not found!");
		} catch(Exception e){
			System.err.println(e);
		}
	} 
}
