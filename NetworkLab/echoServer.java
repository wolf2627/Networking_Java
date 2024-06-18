import java.io.*;
import java.net.*;

class echoServer{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(4000);
			System.out.println("Server Powered on, Waiting for client to connect");
			try{
				Socket s = ss.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				
				System.out.println("Client Connected");
				
				String message;
				
				while((message=in.readLine())!=null){
					if(message.equals("bye")){
						break;
					} 
					System.out.println("Client : "+message);
					out.println("Server : "+message);
				}
				System.out.println("Client Disconnected");
			} catch(IOException e){
				System.err.println("Error Occured, with Client : "+e.getMessage());
			}
	
		} catch(IOException e) {
			System.err.println("Server Cannot be Powered on : "+e.getMessage());
		}
	}
	
}
