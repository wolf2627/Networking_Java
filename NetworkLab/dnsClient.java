import java.net.*;
import java.io.*;
import java.util.*;

class dnsClient{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the server address: ");
		String ipaddress = sc.nextLine();
		InetAddress ipaddr = null;
		try {
		    ipaddr = InetAddress.getByName(ipaddress);
		} catch (UnknownHostException e) {
		    System.err.println("Invalid server address");
		    return;
		}
		System.out.println("Enter the port : ");
		int port = sc.nextInt();
		try{
			DatagramSocket ds = new DatagramSocket();
			byte[] senddata = new byte[1024];
			byte[] recvdata = new byte[1024];
			BufferedReader getin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Domain name: ");
			String request = getin.readLine();
			senddata = request.getBytes();
			DatagramPacket dsp = new DatagramPacket(senddata, senddata.length, ipaddr, port);
			ds.send(dsp);
			DatagramPacket drp = new DatagramPacket(recvdata, recvdata.length);
			ds.receive(drp);
			String response = new String(drp.getData());
			System.out.println("Ip : "+response);
			ds.close();
		}catch(Exception e){
			System.err.println(e);
		}
	} 
}
