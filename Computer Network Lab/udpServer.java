import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpServer {
    public static int client = 789;
    public static int server = 790;
    private static DatagramSocket ds;

    public static void main(String[] args) throws IOException {
        String s;
        InetAddress id = InetAddress.getLocalHost();
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        ds = new DatagramSocket(server);
        byte b[] = new byte[1024];
        System.out.println("Server Side.. Sending..");
        System.out.println("\n" + id);
        while (true) {
            s = dis.readLine();
            if (s.equals("end")) {
                b = s.getBytes();
                DatagramPacket dp = new DatagramPacket(b, s.length(), id, client);
                ds.send(dp);
                break;
            } else {
                b = s.getBytes();
                DatagramPacket dp = new DatagramPacket(b, s.length(), id, client);
                ds.send(dp);
            }
        }
    }
}
