//http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
import java.io.*;
import java.net.*;

class HelloProxy implements Runnable{
  private Thread thread;
  Socket socket;
  InputStream in;
  PrintWriter out;
  int character;


  public HelloProxy() {
    try{
      socket = new Socket("localhost", 8765);
      System.out.println("Connecting....");
      in = socket.getInputStream();
      out = new PrintWriter (socket.getOutputStream(), true);
      thread = new Thread(this);
      thread.start();
    } catch (IOException ioe){
      System.err.println("The server must be running.");
      System.err.println("Not connected");
    } catch (Exception e){
      System.err.println(e.getMessage());
    }
    if(socket != null && socket.isConnected()){
      System.out.println("Connected");
    }
  }    
    
  public String sayHello() {
    out.println("sayHello");
    return "";
  }
  
  public String goodMorning() {
    out.println("goodMorning"); 
    return "";
  }

  public void run() {
    try{
      while ((character = in.read()) != -1) {
        System.out.print((char) character);
      }
    } catch(Exception ex){
      System.out.println(ex.getMessage());
    }
  }
}

public class AppProxy {
  HelloProxy proxy;

  public static void main(String args[]) {
    AppProxy appProxy = new AppProxy();
  }

  public AppProxy() {
    proxy = new HelloProxy();
    proxy.sayHello();
    proxy.goodMorning();
  }
}

// Run the ProxyServer in a separate command window.
// The AppProxy in another.
    