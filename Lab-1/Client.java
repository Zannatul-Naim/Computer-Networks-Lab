import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 7878);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());

        Scanner scan = new Scanner(System.in);
        String msg;

        do {
            String str = "Client: ";
            System.out.print(str);
            msg = scan.next();
            dout.writeUTF(msg);

            String server_response_string = (String) din.readUTF();
            System.out.println("Server: " + server_response_string);

        } while(!msg.toLowerCase().equals("quit"));
        
        scan.close();
        dout.close();
        s.close();
    }
}