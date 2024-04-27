import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 7878);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        Scanner scan = new Scanner(System.in);
        String msg;
        do {
            String str = "Enter a message: ";
            System.out.println(str);
            msg = scan.next();
            dout.writeUTF(msg);
        } while(!msg.toLowerCase().equals("quit"));
        
        scan.close();
        dout.close();
        s.close();
    }
}