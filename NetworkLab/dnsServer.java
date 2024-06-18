import java.util.*;
import java.net.*;
import java.io.*;

class dnsServer{

	private static int index(String[] hosts, String request){
		request = request.trim();
		for(int i=0;i<hosts.length;i++){
			if(request.equals(hosts[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
	
		String hosts[] = {"google.com", "example.com", "youtube.com"};
		String ip[] = {"1.0.0.1", "2.09.89.0", "7.90.09.8"};
		try{
			while(true){
				DatagramSocket ds = new DatagramSocket(4000);
				byte[] recvdata = new byte[1024];
				byte[] senddata = new byte[1024];
				DatagramPacket dp = new DatagramPacket(recvdata, recvdata.length);
				ds.receive(dp);
				String request = new String(dp.getData());
				InetAddress ipaddr = dp.getAddress();
				int port = dp.getPort();
				
				System.out.println("Request for : "+request);
				String result;
				
				if((index(hosts, request))!=-1){
					result = ip[index(hosts, request)];
				} else {
					result = "Host Not Found";
				}
				
				senddata = result.getBytes();
				DatagramPacket dsp = new DatagramPacket(senddata, senddata.length, ipaddr, port);
				ds.send(dsp);
				ds.close();
			}
		} catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}
}
