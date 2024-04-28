import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.DataOutputStream;

public class Server {
    public static void main(String[] args) throws Exception{
        
        ServerSocket serverSocket = new ServerSocket(7878);
        Socket s = serverSocket.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        String str;

        do {
            str = (String) din.readUTF();

            if(str.equalsIgnoreCase("hi")) {
                dout.writeUTF("Hello!");
            } else if(str.equalsIgnoreCase("time")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
                LocalTime timeNow = LocalTime.now();
                String timeString = timeNow.format(formatter);
                dout.writeUTF(timeString);
            } else if(str.equalsIgnoreCase("quit")){
                dout.writeUTF("Quitting...");
            } else {
                dout.writeUTF("Unknown!");
            }
        } while(!str.equals("quit"));

        serverSocket.close();

    }
}
