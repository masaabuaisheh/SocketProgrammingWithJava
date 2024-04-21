import java.io.*;
import java.net.*;

class TCPServer {
         public static void main(String argv[]) throws Exception
      {
	        String value="0";
            String clientSentence;
            String capitalizedSentence;
            ServerSocket welcomeSocket = new ServerSocket(7851);
            
            while(true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new
            		BufferedReader(new 
            				InputStreamReader(connectionSocket.getInputStream()));
            
            DataOutputStream outToClient = new
            		DataOutputStream(connectionSocket.getOutputStream());
            
            clientSentence = inFromClient.readLine();
           //Read Data 
            int i=0;
            String s=null;
            
            File file=new File("Data.txt");
            
            final RandomAccessFile R;
            R=new RandomAccessFile(new File("Data.txt"),"r");
            
            String array[] = new String[2];
            FileReader F;
            F = new FileReader(file);
            BufferedReader reader = new BufferedReader(F);
  
           while((s = reader.readLine()) != null){
           String k=s;
           array=k.split(",");
           
           if(array[0].trim().equals(clientSentence.trim())){
    	   value = array[1];
    	   i = 1;
           break;
           }
           
           else{
        	   i = 0;
            }
       
       }
           
            if (i == 0) {
	             value = "Vehicle is not found";
            }
  
            else {
            	 System.out.println();
            }
            
            System.out.println(value);
            outToClient.writeBytes(value+'\n');

         }
     }
}

