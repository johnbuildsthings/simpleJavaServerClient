import java.io.*;
import java.net.*;
import java.util.Scanner;

public class simpleClient {

  public static void main(String[] args){
    new simpleClient();
  }

  public simpleClient() {

    Scanner scanner = new Scanner(System.in);
    try{
      Socket socket = new Socket("127.0.0.1", 8080);

      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // String inputString = input.readLine();
      // System.out.println(inputString);
        

      while(true){
        String  userInput = scanner.nextLine();

        // readInput inputString = new readInput(socket);
        String inputString = input.readLine();
        System.out.println(inputString);
        
        if(userInput.equals("close")){
          output.println(userInput);
          break;
        }else{
          // System.out.println("sending data to server");
          output.println(userInput);
        }
          
      }

    }catch(IOException exception) {
      System.out.println("Error: " + exception);
    }
  }

  // class readInput{
  //   Socket socket;

  //   public readInput(Socket socket){
  //     socket = socket;
  //   }

  //   public void run(){
  //     // String inputString = "";
  //     try{

        
  //       while(true){
  //         System.out.println(inputString);
  //       }
  //     }catch (IOException exception){
  //       System.out.println("Error: " + exception);
  //     }
  //     // return inputString;
  //   }
  // }
}