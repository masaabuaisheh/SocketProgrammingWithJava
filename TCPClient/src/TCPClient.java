import java.io.*;
import java.net.*;

class TCPClient {
        public static void main(String argv[]) throws Exception
      {
	
          String sentence;
          String modifiedSentence;
          
          while(true){
        	  
          BufferedReader inFromUser = 
        		  new BufferedReader(new
        				  InputStreamReader(System.in));
          
          Socket clientSocket = 
        		  new Socket("192.168.1.18",7851);
          
          DataOutputStream outToServer = 
        		  new DataOutputStream(clientSocket.getOutputStream());
          
          BufferedReader inFromServer = 
        		  new BufferedReader(new 
        				  InputStreamReader(clientSocket.getInputStream()));
          
          sentence = inFromUser.readLine();
          outToServer.writeBytes(sentence + '\n');
          modifiedSentence = inFromServer.readLine();
          
          System.out.println("FROM SERVER: " + modifiedSentence);
          clientSocket.close();


          }
       }
}