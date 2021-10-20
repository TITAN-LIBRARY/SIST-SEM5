import java.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

import java.util.*;

class DateServer {
    public static void main(String[] args) {
        ServerSocket ss;
        Socket s;
        PrintStream ps;
        DataInputStream dis;
        String inet;
        try {
            ss = new ServerSocket(8020);
            while (true) {
                s = ss.accept();
                ps = new PrintStream(s.getOutputStream());
                Date d = new Date();
                ps.println(d);
                ps.close();
            }
        } catch (IOException e) {
            System.out.println("The exception is: " + e);
        }
    }
}
