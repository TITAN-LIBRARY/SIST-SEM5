import java.net.*;
import java.io.*;

public class FTPClient {
  public static void main(String args[]) throws Exception {
    Socket s = new Socket(InetAddress.getLocalHost(), 4000);
    // reading the file name from keyboard. Uses input stream
    System.out.println("Enter the file name");
    BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
    String fname = keyRead.readLine();
    // sending the file name to server. Uses PrintWriter
    OutputStream ostream = s.getOutputStream();
    PrintWriter pwrite = new PrintWriter(ostream, true);
    pwrite.println(fname);
    // receiving the contents from server. Uses input stream
    InputStream istream = s.getInputStream();
    BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
    String str;
    while ((str = socketRead.readLine()) != null) // reading line-by-line
    {
      System.out.println(str);
    }
    pwrite.close();
    socketRead.close();
    keyRead.close();
  }
}