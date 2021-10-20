import java.io.*;
import java.net.*;

public class FTPServer {
  public static void main(String args[]) throws Exception { // establishing the connection with the server
    ServerSocket ss = new ServerSocket(4000);
    System.out.println("Server ready for connection");
    Socket s = ss.accept(); // binding with port: 4000
    System.out.println("Connection is successful and wating for chatting");
    // reading the file name from client
    InputStream istream = s.getInputStream();
    BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
    String fname = fileRead.readLine();
    // reading file contents
    BufferedReader contentRead = new BufferedReader(new FileReader(fname));
    // keeping output stream ready to send the contents
    OutputStream ostream = s.getOutputStream();
    PrintWriter pwrite = new PrintWriter(ostream, true);
    String str;
    while ((str = contentRead.readLine()) != null) // reading line-by-line from file
    {
      pwrite.println(str); // sending each line to client
    }
    s.close();
    ss.close(); // closing network sockets
    pwrite.close();
    fileRead.close();
    contentRead.close();
  }
}