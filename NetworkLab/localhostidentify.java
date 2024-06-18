import java.util.*;
import java.net.*;

class localhostidentify{
	public static void main(String[] args){
		try{
			InetAddress addr = InetAddress.getLocalHost();
			//System.out.println(addr);
			System.out.println("Host Name: "+ addr.getHostName());
			System.out.println("Host Address: "+addr.getHostAddress());
		} catch(Exception e) {
			System.err.println(e);
		}
	}
}
