import java.net.*;
import java.io.*;


public class Test{
    public static void main(String[] args) throws IOException{
       Socket sock = null;
       BufferedReader in = null, user = null;
       PrintWriter out = null;
       int port = 4000;
       try {
        if(args.length == 0){
            sock = new Socket(InetAddress.getLocalHost(), port);
        } else {
            sock = new Socket(InetAddress.getByName(args[0]), port);
        } 

        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())), true);

        in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        user = new BufferedReader(new InputStreamReader(System.in));

        String intext, outtext;
        while (true){

            System.out.print("Message to Server: ");
            outtext = user.readLine();

            out.println(outtext);

            if(outtext.equals("end")){
                break;
            }
            intext = in.readLine();
            System.out.println("Client <<< "+ intext);
        }

       } catch(Exception e){
            System.err.println(e);
       } finally{
        in.close();
        out.close();
        user.close();
        sock.close();
       }

    } 
}