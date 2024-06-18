import java.net.*;
import java.util.*;
import java.io.*;

class fileClient{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the host address: ");
		String hostaddr = sc.nextLine();
		System.out.println("Enter the port: ");
		int port = sc.nextInt();
		try{
			Socket s = new Socket(hostaddr, port);
			BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			System.out.print("Enter the file name : ");
			String filename = userinput.readLine();
			dout.writeBytes(filename+"\n");
			
			System.out.print("Enter the new file name: ");
			String newfilename = userinput.readLine();
			
			FileWriter f = new FileWriter(newfilename);
			String content;
			while(true){	
				content = din.readLine();
				if(content.equals("-1")){
					break;
				}
				System.out.println(content);
				f.write(content +"\n");
			}
			f.close();
			s.close();
			
		} catch(Exception e){
			System.err.println(e);
		}
	}
}
