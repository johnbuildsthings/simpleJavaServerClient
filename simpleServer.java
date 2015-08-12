import java.net.*;
import java.util.*;
import java.io.*;

public class simpleServer {

  public static void main(String[] args) {
    new simpleServer();
  }

  public simpleServer() {

    try{
      ServerSocket sSocket = new ServerSocket(8080);
      System.out.println("Server started at: " + new Date());


      // PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
      // BufferedReader input = new BufferedReader(new InputStreamReader (socket.getInputStream()));

      // output.println("You have connected at: " + new Date());

      while(true){
        Socket socket = sSocket.accept();

        ClientThread cT = new ClientThread(socket);

        new Thread(cT).start();
        // String chatInput = input.readLine();
        // System.out.println(chatInput);
      }

    }catch(IOException exception) {
      System.out.println("Error: " + exception);
    }
  }
  
  class ClientThread implements Runnable {
    Socket threadSocket;

    public ClientThread(Socket socket){
      threadSocket = socket;
    }

    public void run(){
      try {
        PrintWriter output = new PrintWriter(threadSocket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(threadSocket.getInputStream()));

        output.println("You have connected at: " + new Date());

        while(true){
          String chatInput = input.readLine();
          if(chatInput.equals("close")){
            threadSocket.close();
            // break;
          }else{
            System.out.println(chatInput);
            output.println("Your message was recieved"); 
          }

        }
      } catch(IOException exception) {
        System.out.println("Error: " + exception);
      }
    }
  }
}