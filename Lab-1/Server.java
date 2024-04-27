import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class Server {
    public static void main(String[] args) throws Exception{
        
        ServerSocket serverSocket = new ServerSocket(7878);
        Socket s = serverSocket.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());
        String str;
        do {
            str = (String) din.readUTF();

            if(str.toLowerCase().equals("hi")) {
                System.out.println("Hello!");
            } else if(str.toLowerCase().equals("time")) {
                System.out.println(LocalDate.now());
            } else if(str.toLowerCase().equals("quit")){
                System.out.println("Quitting ...!");
            } else {
                System.out.println("Unknown!");
            }
        } while(!str.equals("quit"));

        serverSocket.close();

    }
}
