import java.net.*;
import java.util.*;

class remotehostidentify{
	public static void main(String[] args){
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the remote host address : ");
			String remote_addr = sc.nextLine();
			InetAddress ip = InetAddress.getByName(remote_addr);
			System.out.println("Host Name: "+ip.getHostName());
			System.out.println("Host Address: "+ip.getHostAddress());
		} catch(UnknownHostException e){
			System.err.println("Host address not found.!");
		}
	}
}


