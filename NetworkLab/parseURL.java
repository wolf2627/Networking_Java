import java.util.*;
import java.net.*;

class parseURL{
	public static void main(String[] args) throws Exception{
		URL u = new URL("https://java.sun.com:80/docs/notes/index.html?data=newbook#Document");
		System.out.println("Protocol : "+u.getProtocol());
		System.out.println("Authority : "+u.getAuthority());
		System.out.println("Host : "+u.getHost());
		System.out.println("Port : "+u.getPort());
		System.out.println("Path : "+u.getPath());
		System.out.println("Query : "+u.getQuery());
		System.out.println("File : "+u.getFile());
		System.out.println("Ref : "+u.getRef());
	}
}

