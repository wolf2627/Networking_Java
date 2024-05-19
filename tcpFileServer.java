import java.io.*;
import java.net.*;

class tcpFileServer{
    public static void main(String[] args) {
        try {
            ServerSocket obj = new ServerSocket(1309);
            while (true) {
                Socket obj1 = obj.accept();
                DataInputStream din = new DataInputStream(obj1.getInputStream());
                DataOutputStream dout = new DataOutputStream(obj1.getOutputStream());

                String str = din.readLine();
                FileReader f = new FileReader(str);
                BufferedReader b = new BufferedReader(f);
                String s;
                while ((s = b.readLine()) != null) {
                    System.out.println(s);
                    dout.writeBytes(s + '\n');
                }
                f.close();
                dout.writeBytes("-1\n");

                obj1.close();
                obj.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
