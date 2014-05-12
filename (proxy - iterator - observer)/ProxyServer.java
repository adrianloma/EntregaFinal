import java.io.*;
import java.net.*;

public class ProxyServer implements Runnable {
  private Thread thread;
  ServerSocket socket;
  PrintWriter out;
  Socket communicationSocket;
  
  public ProxyServer() {
    try {    
      socket = new ServerSocket(8765);
      communicationSocket = socket.accept();
      out = new PrintWriter (communicationSocket.getOutputStream(), true);
      thread = new Thread(this);
      thread.start();
    }
    catch (Exception e) {
      System.err.println(e.getMessage());
    } 
  }
  
  public void run()  {
    String inputString;
      try {    
        BufferedReader in = new BufferedReader (new 
                       InputStreamReader(communicationSocket.getInputStream()));
        while ((inputString = in.readLine()) != null){
           System.out.println("Operation received: " + inputString);
           if(inputString.equals("sayHello")) {
              out.println( sayHello() );
           } else if ( inputString.equals("goodMorning")){
              out.println( goodMorning() );
           }
        }
      }catch (Exception e) { 
        System.err.println(e.getMessage());
      } 
    }

  public String sayHello() { 
    return "Hello client, got your message.";
  }
  
  public String goodMorning() { 
    return "Good morning to you, client.";
  }
  
  public static void main(String args[]) {
    ProxyServer server = new ProxyServer();
  }
}
