import java.io.*;
import java.net.*;

public class udpClient {
    public static int client = 789;
    private static DatagramSocket ds;
    private static DatagramSocket datagramSocket;

    public static void main(String[] args) throws IOException {
        datagramSocket = new DatagramSocket(client);
        ds = datagramSocket;
        byte b[] = new byte[1024];
        System.out.println("Client... Recieving...");
        while (true) {
            DatagramPacket dp = new DatagramPacket(b, b.length);
            ds.receive(dp);
            String s = new String(dp.getData(), 0, dp.getLength());

            if (s.equals("end"))
                System.out.println(s);
            else
                break;
        }
    }
}
