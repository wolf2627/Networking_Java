import java.util.*;
import java.net.*;
import java.io.*;

class HTTPClient{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the host address: ");
		String host_addr = sc.nextLine();
		int port = 80;
		try{
			Socket s = new Socket(host_addr, port);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			
			out.print("GET / HTTP/1.1\r\n");
		        out.print("Host: " + host_addr + "\r\n");
		    	out.print("Connection: Close\r\n");
		   	out.print("\r\n");
		   	out.flush();
		   	
			String input;
			while((input=in.readLine())!=null){
				System.out.println(input);
			}
			System.out.println("Successful");
			
		} catch(UnknownHostException e){
			System.err.println("Host not found");
		} catch (IOException e){
			System.err.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}
