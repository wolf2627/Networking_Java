import java.net.*;
import java.io.*;
import java.util.*;

class fileServer{
	public static void main(String[] arg){
		try{
			ServerSocket ss = new ServerSocket(4000);
			System.out.println("Server powered on! Waiting for client to connect!");
			try{
				while(true){
					Socket s = ss.accept();
					System.out.println("Client Connected");
					DataInputStream din = new DataInputStream(s.getInputStream());
					DataOutputStream dout = new DataOutputStream(s.getOutputStream());
					String filename = din.readLine();
					FileReader f = new FileReader(filename);
					BufferedReader in = new BufferedReader(f);
					String content;
					while((content=in.readLine())!=null){
						System.out.println(content);
						dout.writeBytes(content+"\n");
					}
					f.close();
					dout.writeBytes("-1\n");
				}
			} catch(Exception e){
				System.err.println(e);
			}
		} catch(Exception e){
			System.err.println(e);
		}
	}
}
