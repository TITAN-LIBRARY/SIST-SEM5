
import java.io.*;
import java.net.*;

public class ServerIP {
    public static void main(String[] args) {
        ServerSocket ss;
        Socket s;
        String ip;
        DataInputStream dis;
        try {
            ss = new ServerSocket(8020);
            while (true) {
                s = ss.accept();
                dis = new DataInputStream(s.getInputStream());
                ip = dis.readLine();
                System.out.println("Ip Address client system: " + ip);
            }
        } catch (IOException e) {
            System.out.println("The exception is: " + e);
        }
    }
}
